package com.ltp.gradesubmission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// This is a validator class with the rules to validate some custom values, in this case, validating a score with a range of possible score values
public class ScoreValidator implements ConstraintValidator<Score, String> {

    Set<String> scores =  new HashSet<>(Arrays.asList(
            "A+", "A", "A-",
            "B+", "B", "B-",
            "C+", "C", "C-",
            "F"
    ));

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (String string : scores) {
            if (value.equals(string)) {
                return true;
            }
        }
        return false;
    }
}
