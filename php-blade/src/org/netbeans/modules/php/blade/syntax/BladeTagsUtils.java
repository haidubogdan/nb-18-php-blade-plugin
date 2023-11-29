package org.netbeans.modules.php.blade.syntax;

/**
 *
 * @author bhaidu
 */
public class BladeTagsUtils {

    public static String[] outputCloseTags() {
        return new String[]{"}}", "!!}"};
    }

    public static String[] outputStartTags() {
        return new String[]{"{{", "{!!"};
    }

    public static String tagStart2EndPair(String tag) {
        switch (tag) {
            case "{{":
                return "}}";
            case "{!!":
                return "!!}";
        }
        return null;
    }

    public static String tagEnd2StartPair(String tag) {
        switch (tag) {
            case "}}":
                return "{{";
            case "!!}":
                return "{!!";
        }
        return null;
    }
}
