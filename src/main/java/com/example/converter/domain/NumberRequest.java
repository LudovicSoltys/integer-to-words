package com.example.converter.domain;

import com.example.converter.service.DigitsExtractUtil;

/**
 * Encapsulation for an {@link Integer}
 */
public class NumberRequest {

    private final Integer value;

    private final ThreeDigits millions;

    private final ThreeDigits thousands;

    private final ThreeDigits units;

    private final Integer max = 999999999;

    private final Integer min = 0;

    public NumberRequest(Integer value) {

        if (value == null) {
            throw new IllegalArgumentException("Expect only numbers between " + min + " and " + max + ". Actual value is null");
        }

        if (value > max || value < min) {
            throw new IllegalArgumentException("Expect only numbers between " + min + " and " + max + ". Actual value is " + value);
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
