package org.netbeans.modules.php.blade.syntax;

/**
 *
 * @author bhaidu
 */
public class BladeDirectivesUtils {

    public static String[] directiveStart2EndPair(String directive) {
        switch (directive) {
            case "@if":
            case "@hasSection":
                return new String[]{"@endif"};
            case "@section":
                return new String[]{"@endsection"};
            case "@once":
                return new String[]{"@endonce"};
            case "@foreach":
                return new String[]{"@endforeach"};
            case "@for":
                return new String[]{"@endfor"};
            case "@while":
                return new String[]{"@endwhile"};
            case "@php":
                return new String[]{"@endphp"};
            case "@unless":
                return new String[]{"@endunless"};
            case "@isset":
                return new String[]{"@endisset"};
            case "@empty":
                return new String[]{"@endempty"};
            case "@error":
                return new String[]{"@enderror"};

        }
        return null;
    }

    public static String[] directiveEnd2StartPair(String directive) {
        switch (directive) {
            case "@endif":
                return new String[]{"@if", "@hasSection"};
            case "@endsection":
                return new String[]{"@section"};
            case "@endonce":
                return new String[]{"@once"};
            case "@endforeach":
                return new String[]{"@foreach"};
            case "@endfor":
                return new String[]{"@for"};
            case "@endphp":
                return new String[]{"@php"};
            case "@endunless":
                return new String[]{"@unless"};
            case "@endisset":
                return new String[]{"@isset"};
            case "@endempty":
                return new String[]{"@empty"};
            case "@enderror":
                return new String[]{"@error"};
        }
        return null;
    }
}
