<div>
    @if ($var)

        @foreach($test as $varl)
            @if ($var)
                @include("admin")
    <div>
    </div>
    {{-- test'dd' --}}
            @endif
        @endforeach
    @endif

</div>
