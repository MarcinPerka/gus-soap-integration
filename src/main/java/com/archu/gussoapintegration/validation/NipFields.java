package com.archu.gussoapintegration.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NipFieldsValidator.class)
public @interface NipFields {

    String message() default "{validator.nip-fields.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}