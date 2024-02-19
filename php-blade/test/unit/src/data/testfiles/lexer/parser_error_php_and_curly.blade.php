<?php
if ($test){
    if (!empty($test2)){
        $myValue = $myValue2;
    } elseif (1){
    //don't
        $myValue = MyClass::get($val);
    }

    if (!empty($myValue)){
    }
} else {
    if(!empty($myValue)) {
    } else {
    }
}
?>
<div class="test">
    <div class="mydiv">
        <div class="my_input">
            <div class="error-input-msg">{{$class->getError('error')}}</div>
        </div>
    </div>
</div>
