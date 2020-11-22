package com.archu.gussoapintegration.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = Regon14DigitsFieldsValidator.class)
public @interface Regon14DigitsFields {

    String message() default "List should contains only regons with 14 digits.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}