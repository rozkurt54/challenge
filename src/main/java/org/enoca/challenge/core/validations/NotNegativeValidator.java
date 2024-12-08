package org.enoca.challenge.core.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.enoca.challenge.core.validations.annotations.NotNegative;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NotNegativeValidator implements ConstraintValidator<NotNegative, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) {
            return false;
        }

        if (value instanceof Number) {

            Number number = (Number) value;

            if (number instanceof BigDecimal) {
                return ((BigDecimal) number).compareTo(BigDecimal.ZERO) >= 0;
            }
            if (number instanceof BigInteger) {
                return ((BigInteger) number).compareTo(BigInteger.ZERO) >= 0;
            }
            if (number instanceof Float) {
                return ((Float) number) >= 0;
            }

            if (number instanceof Double) {
                return ((Double) number) >= 0;
            }

            if (number instanceof Integer) {
                return ((Integer) number) >= 0;
            }

            if (number instanceof Long) {
                return ((Long) number) >= 0;
            }

            if (number instanceof Short) {
                return (Short) value  >= 0;
            }

            if (number instanceof Byte) {
                return (Byte) value  >= 0;
            }
        }

        if (value.getClass().isPrimitive()) {

            return (float) value >= 0;

        }

        return false;
    }
}
