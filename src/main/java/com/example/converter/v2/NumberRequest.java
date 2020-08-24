package com.example.converter.v2;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

/**
 * Encapsulation for a {@link String}
 */
class NumberRequest {

    private final String absoluteValue;

    private final boolean isLowerThanZero;

    private static final Pattern NUMBER_ONLY_PATTERN = Pattern.compile("^-?\\d+$");

    private static final Pattern ZERO_PATTERN = Pattern.compile("^0+$");

    NumberRequest(String value) {

        if (value == null) {
            throw new IllegalArgumentException("Expect numbers only. Actual value is null");
        }

        if (!NUMBER_ONLY_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Expect numbers only. Actual value is " + value);
        }

        isLowerThanZero = value.startsWith("-");
        absoluteValue = isLowerThanZero ? value.substring(1) : value;

        if (absoluteValue.length() > 27) {
            throw new IllegalArgumentException("Expect less than 27 digits. Actual value has " + absoluteValue.length() + " elements");
        }

    }

    public boolean isZero() {

        return ZERO_PATTERN.matcher(absoluteValue).find();
    }

    public boolean isLowerThanZero() {
        return isLowerThanZero;
    }

    public int size() {
        return absoluteValue.length();
    }

    public String getAbsoluteValue() {
        return absoluteValue;
    }
}
