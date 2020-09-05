package com.example.converter.v2.english;

import java.util.function.Function;

/**
 * Basic function for transforming a {@link EnglishNumber} that has less than 18 characters (< {@link Long#MAX_VALUE})
 */
public class ShortNumberToThreeDigitsFunction implements Function<EnglishNumber, ThreeDigits> {

    private final int beginIndex;

    private final int endIndex;

    public ShortNumberToThreeDigitsFunction(int powerOfTen) {
        if (powerOfTen > 15) {
            throw new IllegalArgumentException("Input shall have less than 18 characters");
        }

        this.endIndex = powerOfTen + 3;
        this.beginIndex = powerOfTen;
    }

    @Override
    public ThreeDigits apply(EnglishNumber input) {

        int length = input.length();
        if (length < beginIndex) {
            return ThreeDigits.zero();
        }

        String value = input.getAbsoluteValue().substring(Math.max(length - endIndex, 0), length - beginIndex);

        return ThreeDigits.threeDigits(value);
    }
}
