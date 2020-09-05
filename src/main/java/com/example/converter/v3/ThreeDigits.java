package com.example.converter.v3;

import org.immutables.value.Value;

import java.util.regex.Pattern;

/**
 * Utility class that manages Integers between 0 and 999
 */
@Value.Immutable
public interface ThreeDigits {

    String getValue();

    default boolean isNotZero() {
        return !Pattern.compile("^0+$").matcher(getValue()).matches();
    }

    static ThreeDigits threeDigits(String value) {

        return ImmutableThreeDigits.builder().value(value).build();
    }

    static ThreeDigits zero() {
        return threeDigits("0");
    }
}
