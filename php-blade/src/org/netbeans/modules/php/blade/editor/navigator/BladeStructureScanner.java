package org.netbeans.modules.php.blade.editor.navigator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.api.StructureItem;
import org.netbeans.modules.csl.api.StructureScanner;
import org.netbeans.modules.csl.api.StructureScanner.Configuration;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;

/**
 *
 *
 * 
 * @author bhaidu
 */
public class BladeStructureScanner implements StructureScanner {

    @Override
    public List<? extends StructureItem> scan(ParserResult info) {
        if (info instanceof BladeParserResult) {
            return ((BladeParserResult) info).structure;
        }
        return new ArrayList<>();
    }

    @Override
    public Map<String, List<OffsetRange>> folds(ParserResult info) {
         List<OffsetRange> folds = new ArrayList<>();

        if (info instanceof BladeParserResult) {
            folds = ((BladeParserResult) info).folds;
        }

        return Collections.singletonMap("tags", folds);
    }

    @Override
    public Configuration getConfiguration() {
        return new Configuration(true, false);
    }

}
