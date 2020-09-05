package com.example.converter.v2.english;

import org.immutables.value.Value;

/**
 * Utility class that manages Integers between 0 and 999
 */
@Value.Immutable
public interface ThreeDigits {

    Integer getValue();

    default boolean has2LastDigitsLowerThan20() {
        return getValue() % 100 < 20;
    }

    /**
     *
     * @return le reste du modulo par 10 de value
     */
    default Integer getUnit() {
        return getValue() % 10;
    }

    /**
     *
     * @return le reste du modulo par 10 de (value / 10)
     */
    default Integer getTen() {
        return (getValue() / 10) % 10;
    }

    /**
     *
     * @return value / 100
     */
    default Integer getHundred() {
        return getValue() / 100;
    }

    /**
     *
     * @return le reste du modulo par 100 de value
     */
    default Integer getTenAndUnit() {

        return getValue() % 100;
    }

    /**
     *
     * @return value est la valeur 0
     */
    default boolean isZero() {
        return getValue() == 0;
    }

    default boolean isNotZero() {
        return getValue() != 0;
    }

    static ThreeDigits zero() {
        return threeDigits(0);
    }

    static ThreeDigits threeDigits(Integer value) {
        if (value < 0 || value > 999) {
            throw new IllegalArgumentException("Expected only values between 0 and 999. Actual value is " + value);
        }
        return ImmutableThreeDigits.builder().value(value).build();
    }

    static ThreeDigits threeDigits(String value) {
        if (value.isEmpty()) {
            return ThreeDigits.zero();
        }

        String tmpValue = TranslationUtil.DECIMAL_FORMAT.format(Integer.parseInt(value));
        return threeDigits(Integer.parseInt(tmpValue));
    }
}
