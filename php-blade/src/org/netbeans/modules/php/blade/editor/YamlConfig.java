/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openide.util.Exceptions;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.events.Event;
import static org.snakeyaml.engine.v2.events.Event.ID.MappingEnd;
import static org.snakeyaml.engine.v2.events.Event.ID.MappingStart;
import static org.snakeyaml.engine.v2.events.Event.ID.Scalar;
import static org.snakeyaml.engine.v2.events.Event.ID.SequenceEnd;
import static org.snakeyaml.engine.v2.events.Event.ID.SequenceStart;
import org.snakeyaml.engine.v2.events.ScalarEvent;
import org.snakeyaml.engine.v2.parser.ParserImpl;
import org.snakeyaml.engine.v2.scanner.ScannerImpl;
import org.snakeyaml.engine.v2.scanner.StreamReader;

/**
 * @Todo extract one line directives
 * 
 * @author bogdan
 */
public class YamlConfig {

    private final static LoadSettings SETTINGS = LoadSettings.builder().build();

    public static HashMap<String, HashMap> getConfigMapping(String filePath) {
        ScannerImpl scanner;
        HashMap<String, HashMap> groupSequenceMap = new HashMap<>();
        try {
            scanner = new ScannerImpl(SETTINGS, new StreamReader(SETTINGS, getResourceContent(filePath)));
            ParserImpl parser = new ParserImpl(SETTINGS, scanner);
            List<HashMap> attributesList = new ArrayList<>();
            HashMap<String, String> entry = new HashMap<>();
            HashMap<String, List<HashMap>> groupMap = new HashMap<>();

            String directiveName = "", groupName = "", attributeName = "";
            int scalarCount = 0;

            int treeLevel = 1;

            while (parser.hasNext()) {
                Event.ID eventId = parser.peekEvent().getEventId();
                switch (eventId) {
                    case MappingStart:
                        scalarCount = 0;
                        parser.next();
                        break;
                    case MappingEnd:
                        if (treeLevel == 3) {
                            attributesList.add(entry);
                        }
                        parser.next();
                        break;
                    case SequenceStart:
                        treeLevel++;
                        attributesList = new ArrayList<>();
                        if (treeLevel == 2) {
                            groupMap = new HashMap<>();
                        }
                        parser.next();
                        break;
                    case SequenceEnd:
                        treeLevel--;
                        if (treeLevel == 2 && !directiveName.isEmpty()) {
                            groupMap.put(directiveName, attributesList);
                        }
                        if (treeLevel == 1 && !groupName.isEmpty()) {
                            groupSequenceMap.put(groupName, groupMap);
                        }
                        parser.next();
                        break;
                    case Scalar:
                        scalarCount++;
                        ScalarEvent ret = (ScalarEvent) parser.next();

                        switch (treeLevel) {
                            case 3:
                                if (scalarCount == 1) {
                                    attributeName = ret.getValue();
                                } else if (scalarCount == 2) {
                                    entry = new HashMap();
                                    entry.put(attributeName, ret.getValue());
                                }
                                break;
                            case 2:
                                directiveName = ret.getValue();
                                break;
                            case 1:
                                groupName = ret.getValue();
                                break;
                            default:
                                break;
                        }

                        break;
                    default:
                        parser.next();
                }
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
        return groupSequenceMap;
    }

    public static String getResourceContent(String filePath) throws Exception {
        ClassLoader cl = YamlConfig.class.getClassLoader();
        InputStream stream = cl.getResourceAsStream("org/netbeans/modules/php/blade/resources/directives_list.yml");
        StringBuilder sb = new StringBuilder();
        for (int ch; (ch = stream.read()) != -1;) {
            sb.append((char) ch);
        }
        return sb.toString();
    }

}
