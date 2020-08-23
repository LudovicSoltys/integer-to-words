package com.example.converter.v2;

import java.util.function.Function;

/**
 * Function for transforming a {@link NumberRequest} that has more than 18 characters ({@link Long#MAX_VALUE} and above)
 */
public class OverLongNumberToThreeDigitsFunction implements Function<NumberRequest, ThreeDigits> {

    private final int endIndex;

    public OverLongNumberToThreeDigitsFunction(int powerOfTen) {
        if (powerOfTen < 18) {
            throw new IllegalArgumentException("Input shall have more than 18 characters");
        }
        this.endIndex = powerOfTen;
    }

    @Override
    public ThreeDigits apply(NumberRequest input) {

        int size = input.size();

        String value = input.getValue().substring(Math.max(size - endIndex - 3, 0), Math.max(size - endIndex, 0));

        if (value.isEmpty()) {
            return ThreeDigits.zero();
        } else {
            return new ThreeDigits(
                    Integer.parseInt(DigitsExtractUtil.DECIMAL_FORMAT.format(Integer.parseInt(value))));
        }
    }
}
