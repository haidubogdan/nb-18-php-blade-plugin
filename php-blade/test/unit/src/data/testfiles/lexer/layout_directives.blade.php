@extends("layout.layout")

<div>
    @section("test")
        @yield("my_test")
        @include( "my.inc", ['data' => $data], )
    @endsection
</div>
