package com.karpusha.university.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompareBeginAndEndLessonDateValidator implements ConstraintValidator<CompareBeginAndEndLessonDate,String> {
    @Override
    public void initialize(CompareBeginAndEndLessonDate constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
