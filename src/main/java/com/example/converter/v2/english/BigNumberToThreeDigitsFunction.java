package com.example.converter.v2.english;

import java.util.function.Function;

/**
 * Function for transforming a {@link EnglishNumber} that has more than 18 characters ({@link Long#MAX_VALUE} and above)
 */
class BigNumberToThreeDigitsFunction implements Function<EnglishNumber, ThreeDigits> {

    private final int endIndex;

    public BigNumberToThreeDigitsFunction(int powerOfTen) {
        if (powerOfTen < 18) {
            throw new IllegalArgumentException("Input shall have more than 18 characters");
        }

        this.endIndex = powerOfTen;
    }

    @Override
    public ThreeDigits apply(EnglishNumber input) {

        int size = input.length();

        String value = input.getAbsoluteValue().substring(Math.max(size - endIndex - 3, 0), Math.max(size - endIndex, 0));

        return ThreeDigits.threeDigits(value);
    }
}
