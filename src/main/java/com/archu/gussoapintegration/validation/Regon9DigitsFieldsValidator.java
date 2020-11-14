package com.archu.gussoapintegration.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class Regon9DigitsFieldsValidator implements ConstraintValidator<Regon9DigitsFields, List<String>> {

    @Override
    public boolean isValid(List<String> regons, ConstraintValidatorContext context) {
        return regons == null || regons.stream().allMatch(it -> it != null && it.matches("[0-9]{9}"));
    }
}