package com.ltp.gradesubmission;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// This is a custom validation annotation created to validate Scores by calling the ScoreValidator class that does the validation
// When defining a constraint annotation, we must always define the "groups" and the "payload" parameters like below. Just like it is below.
// If you need something like this, but don't know what to do, just copy&paste everything below as is.
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ScoreValidator.class)
public @interface Score {
    String message() default "Invalid Data"; // Default error message when the validation fails
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
