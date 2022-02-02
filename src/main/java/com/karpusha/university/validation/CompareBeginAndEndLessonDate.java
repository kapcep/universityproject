package com.karpusha.university.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompareBeginAndEndLessonDateValidator.class)
public @interface CompareBeginAndEndLessonDate {
    String message() default "Beginning date can not be less than end date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
