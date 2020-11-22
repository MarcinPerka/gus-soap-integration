package com.archu.gussoapintegration.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NipFieldsValidator.class)
public @interface NipFields {

    String message() default "List should contains only nips with 10 digits.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}