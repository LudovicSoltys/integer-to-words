package com.example.converter.v2;

import java.util.regex.Pattern;

/**
 * Encapsulation for an {@link Integer}
 */
class NumberRequest {

    private final String value;

    private static final Pattern NUMBER_ONLY_PATTERN = Pattern.compile("^\\d+$");

    private static final Pattern ZERO_PATTERN = Pattern.compile("^0+$");

    NumberRequest(String value) {

        if (value == null) {
            throw new IllegalArgumentException("Expect numbers only. Actual value is null");
        }

        if (!NUMBER_ONLY_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Expect numbers only. Actual value is " + value);
        }

        this.value = value;
    }

    public boolean isZero() {

        return ZERO_PATTERN.matcher(value).find();
    }

    public int size() {
        return value.length();
    }

    public String getValue() {
        return value;
    }
}
