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
            case "@foreach":
                return new String[]{"@endforeach"};
            case "@while":
                return new String[]{"@endwhile"};
            case "@php":
                return new String[]{"@endphp"};

        }
        return null;
    }

    public static String[] directiveEnd2StartPair(String directive) {
        switch (directive) {
            case "@endif":
                return new String[]{"@if", "@hasSection"};
            case "@endsection":
                return new String[]{"@section"};
            case "@endforeach":
                return new String[]{"@foreach"};
            case "@endphp":
                return new String[]{"@php"};
        }
        return null;
    }
}
