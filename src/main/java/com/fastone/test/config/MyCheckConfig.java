package com.fastone.test.config;

import com.fastone.test.enuma.MyCheck;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Configuration
public class MyCheckConfig implements ConstraintValidator<MyCheck,Object> {


    @Override
    public void initialize(MyCheck constraintAnnotation) {
        System.out.println("my check init");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println("111222333");

        return false;
    }
}
