package org.netbeans.modules.php.blade.tools;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import org.netbeans.junit.NbTestCase;
import org.netbeans.modules.languages.yaml.YamlParser;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.parser.ParserImpl;
import org.snakeyaml.engine.v2.scanner.ScannerImpl;
import org.snakeyaml.engine.v2.scanner.StreamReader;
import org.netbeans.modules.languages.yaml.YamlSection;
import org.netbeans.modules.php.blade.syntax.antlr4.BladeUtils;
import org.snakeyaml.engine.v2.events.Event;
import org.snakeyaml.engine.v2.events.ScalarEvent;

/**
 *
 * @author bhaidu
 */
public class ToolsTest extends NbTestCase {

    private final LoadSettings SETTINGS = LoadSettings.builder().build();

    public ToolsTest(String testname) {
        super(testname);
    }

    @Test
    public void test_yaml_parser() throws Exception {
        String content = BladeUtils.getFileContent(new File(getDataDir(), "testfiles/yml/test.yml"));
        ScannerImpl scanner = new ScannerImpl(SETTINGS, new StreamReader(SETTINGS, content));
        ParserImpl parser = new ParserImpl(SETTINGS, scanner);
        
        List<HashMap> attributesList = new ArrayList<>();
        HashMap <String, String> entry = new HashMap<>();
        HashMap<String, List<HashMap>> groupMap = new HashMap<>();
        HashMap<String, HashMap>  groupSequenceMap = new HashMap<>();
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
                    if (treeLevel == 3){
                        attributesList.add(entry);
                    }
                    parser.next();
                    break;
                case SequenceStart:
                    treeLevel++;
                    attributesList = new ArrayList<>();
                    if (treeLevel == 2){
                        groupMap = new HashMap<>();
                    }
                    parser.next();
                    break;
                case SequenceEnd:
                    treeLevel--;
                    if (treeLevel == 2 && !directiveName.isEmpty()){
                        groupMap.put(directiveName, attributesList);
                    }
                    if (treeLevel == 1 && !groupName.isEmpty()){
                        groupSequenceMap.put(groupName, groupMap);
                    }
                    parser.next();
                    break;
                case Scalar:
                    scalarCount++;
                    ScalarEvent ret = (ScalarEvent) parser.next();
                    
                    switch (treeLevel){
                        case 3:
                            if(scalarCount == 1){
                                attributeName = ret.getValue();
                            } else if (scalarCount == 2){
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
        
        int end = 1;
    }

    public File getDataDir() {
        URL codebase = getClass().getProtectionDomain().getCodeSource().getLocation();
        File dataDir = null;
        try {
            dataDir = new File(new File(codebase.toURI()), "data");
        } catch (URISyntaxException x) {
            throw new Error(x);
        }
        return dataDir;
    }
}
