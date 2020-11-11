package com.archu.gussoapintegration.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class KrsFieldsValidator implements ConstraintValidator<KrsFields, List<String>> {

    @Override
    public boolean isValid(List<String> krses, ConstraintValidatorContext context) {
        return krses == null || krses.stream().allMatch(it -> it != null && it.matches("[0-9]{10}"));
    }
}