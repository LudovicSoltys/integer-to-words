package com.example.converter.domain;

/**
 * Utility class that manages Integers between 0 and 999
 */
public class ThreeDigits {

    private final Integer value;

    public ThreeDigits(Integer value) {
        this.value = value;
    }

    public boolean has2LastDigitsLowerThan20() {
        return value % 100 < 20;
    }

    public Integer getUnit() {
        return value % 10;
    }

    public Integer getTen() {
        return (value / 10) % 10;
    }

    public Integer getHundred() {
        return value / 100;
    }

    public Integer getTenAndUnit() {

        return value % 100;
    }

    boolean isZero() {
        return value == 0;
    }
}
