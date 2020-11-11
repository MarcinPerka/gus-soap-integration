package com.archu.gussoapintegration.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Regon14CharsFieldsValidator.class)
public @interface Regon14CharsFields {

    String message() default "{validator.regon-14-chars-fields.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}