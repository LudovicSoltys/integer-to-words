package com.example.converter.v3;

import java.util.regex.Pattern;

public class EnglishNumber {

    private final String absoluteValue;

    private final boolean isLowerThanZero;

    private EnglishNumber(String value) {
        isLowerThanZero = value.startsWith("-");

        this.absoluteValue = isLowerThanZero ? value.substring(1) : value;
    }

    public String getAbsoluteValue() {
        return absoluteValue;
    }

    public boolean isLowerThanZero() {
        return isLowerThanZero;
    }

    public boolean isZero() {
        return Pattern.compile("^0+$").matcher(absoluteValue).matches();
    }

    public static EnglishNumber of(String value) {
        return new EnglishNumber(value);
    }
}
