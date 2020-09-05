package com.example.converter.v2.english;

import java.util.function.Function;

/**
 * Basic function for transforming a {@link EnglishNumber} that has less than 18 characters (< {@link Long#MAX_VALUE})
 */
class LongNumberToThreeDigitsFunction implements Function<EnglishNumber, ThreeDigits> {

    private final int beginIndex;

    public LongNumberToThreeDigitsFunction(int powerOfTen) {
        if (powerOfTen > 15) {
            throw new IllegalArgumentException("Input shall have less than 18 characters");
        }

        this.beginIndex = powerOfTen;
    }

    @Override
    public ThreeDigits apply(EnglishNumber input) {

        int length = input.length();

        String value = input.getAbsoluteValue().substring(Math.max(length - beginIndex - 3, 0), length - beginIndex);

        return ThreeDigits.threeDigits(value);
    }
}
