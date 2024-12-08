package org.enoca.challenge.core.validations.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.enoca.challenge.core.validations.NotNegativeValidator;
import org.enoca.challenge.core.validations.NotZeroValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotZeroValidator.class)
public @interface NotZero {

    String message() default "Value cannot be a negative number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
