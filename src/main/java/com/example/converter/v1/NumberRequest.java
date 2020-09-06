package com.example.converter.v1;

/**
 * Encapsulation for an {@link Integer}
 */
class NumberRequest {

    private final Integer value;

    private final ThreeDigits millions;

    private final ThreeDigits thousands;

    private final ThreeDigits units;

    private static final Integer MAX = 999999999;

    private static final Integer MIN = 0;

    NumberRequest(Integer value) {

        if (value == null) {
            throw new IllegalArgumentException("Expect only numbers between " + MIN + " and " + MAX + ". Actual value is null");
        }

        if (value > MAX || value < MIN) {
            throw new IllegalArgumentException("Expect only numbers between " + MIN + " and " + MAX + ". Actual value is " + value);
        }

        this.value = value;

        this.millions = DigitsExtractUtil.millions(value);
        this.thousands = DigitsExtractUtil.thousands(value);
        this.units = DigitsExtractUtil.units(value);
    }

    public boolean isZero() {

        return value == 0;
    }

    public ThreeDigits getMillions() {
        return millions;
    }

    public boolean hasMillions() {
        return !millions.isZero();
    }

    public boolean hasThousands() {
        return !thousands.isZero();
    }

    public ThreeDigits getThousands() {
        return thousands;
    }

    public ThreeDigits getUnits() {
        return units;
    }
}
