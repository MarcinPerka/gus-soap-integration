package com.archu.gussoapintegration.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NipFieldsValidator implements ConstraintValidator<NipFields, List<String>> {

    @Override
    public boolean isValid(List<String> nips, ConstraintValidatorContext context) {
        return nips == null || nips.stream().allMatch(it -> it != null && it.matches("[0-9]{10}"));
    }
}