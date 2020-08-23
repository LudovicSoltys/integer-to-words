package com.example.converter.v2;

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

    /**
     *
     * @return le reste du modulo par 10 de value
     */
    public Integer getUnit() {
        return value % 10;
    }

    /**
     *
     * @return le reste du modulo par 10 de (value / 10)
     */
    public Integer getTen() {
        return (value / 10) % 10;
    }

    /**
     *
     * @return value / 100
     */
    public Integer getHundred() {
        return value / 100;
    }

    /**
     *
     * @return le reste du modulo par 100 de value
     */
    public Integer getTenAndUnit() {

        return value % 100;
    }

    /**
     *
     * @return value est la valeur 0
     */
    boolean isZero() {
        return value == 0;
    }

    static ThreeDigits zero() {
        return new ThreeDigits(0);
    }
}
