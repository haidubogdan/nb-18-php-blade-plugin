/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.completion;

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
public class CompletionConfig {

    private final static LoadSettings SETTINGS = LoadSettings.builder().build();
    public final static String COMPLETION_CONFIG_V10 = "org/netbeans/modules/php/blade/resources/v10/directives_list.yml";

    public static HashMap<String, HashMap> getConfigMapping(String filePath) {
        ScannerImpl scanner;
        HashMap<String, HashMap> groupSequenceMap = new HashMap<>();
        try {
            scanner = new ScannerImpl(SETTINGS, new StreamReader(SETTINGS, getResourceContent(filePath)));
            ParserImpl parser = new ParserImpl(SETTINGS, scanner);
//            List<HashMap> attributesList = new ArrayList<>();
            HashMap<String, String> attributesList = new HashMap<>();
            HashMap<String, String> entry = new HashMap<>();
            HashMap<String, HashMap> directivesMap = new HashMap<>();

            String directiveName = "", directiveTypeName = "", attributeName = "";
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
                        parser.next();
                        break;
                    case SequenceStart:
                        treeLevel++;
                        attributesList = new HashMap<>();
                        if (treeLevel == 2) {
                            directivesMap = new HashMap<>();
                        }
                        parser.next();
                        break;
                    case SequenceEnd:
                        treeLevel--;
                        if (treeLevel == 2 && !directiveName.isEmpty()) {
                            directivesMap.put(directiveName, attributesList);
                        }
                        if (treeLevel == 1 && !directiveTypeName.isEmpty()) {
                            groupSequenceMap.put(directiveTypeName, directivesMap);
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
                                    attributesList.put(attributeName, ret.getValue());
                                }
                                break;
                            case 2:
                                //in case we don't have any properties for the directive
                                if(!directiveName.isEmpty() && ret.getValue().isEmpty()){
                                    directivesMap.put(directiveName, attributesList);
                                } else {
                                    directiveName = ret.getValue();
                                }
                                attributeName = "";
                                break;
                            case 1:
                                directiveTypeName = ret.getValue();
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
        ClassLoader cl = CompletionConfig.class.getClassLoader();
        InputStream stream = cl.getResourceAsStream(COMPLETION_CONFIG_V10);
        StringBuilder sb = new StringBuilder();
        for (int ch; (ch = stream.read()) != -1;) {
            sb.append((char) ch);
        }
        return sb.toString();
    }

}
