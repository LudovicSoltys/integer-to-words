package com.example.converter.v2;

import java.util.function.Function;

/**
 * Basic function for transforming a {@link NumberRequest} that has less than 18 characters (< {@link Long#MAX_VALUE})
 */
public class NumberToThreeDigitsFunction implements Function<NumberRequest, ThreeDigits> {

    private final int beginIndex;

    private final int endIndex;

    public NumberToThreeDigitsFunction(int powerOfTen) {
        if (powerOfTen > 15) {
            throw new IllegalArgumentException("Input shall have less than 18 characters");
        }

        this.beginIndex = powerOfTen + 3;
        this.endIndex = powerOfTen;
    }

    @Override
    public ThreeDigits apply(NumberRequest input) {

        int size = input.size();
        String value = input.getAbsoluteValue();
        String tmpValue = DigitsExtractUtil.DECIMAL_FORMAT
                .format(Long.parseLong(value.substring(Math.max(size - beginIndex, 0), size - endIndex)));

        return new ThreeDigits(Integer.parseInt(tmpValue));
    }
}
