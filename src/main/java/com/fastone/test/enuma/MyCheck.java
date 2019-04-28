package com.fastone.test.enuma;

import javax.validation.Payload;

public @interface MyCheck {

    String message() default "只是一个测试";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
