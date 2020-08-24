package com.example.converter.v2;

import java.util.function.Function;

/**
 * Basic function for transforming a {@link NumberRequest} that has less than 18 characters (< {@link Long#MAX_VALUE})
 */
public class OtherNumberToThreeDigitsFunction implements Function<NumberRequest, ThreeDigits> {

    private final int beginIndex;

    private final int endIndex;

    public OtherNumberToThreeDigitsFunction(int powerOfTen) {
        if (powerOfTen > 15) {
            throw new IllegalArgumentException("Input shall have less than 18 characters");
        }

        this.beginIndex = powerOfTen + 3;
        this.endIndex = powerOfTen;
    }

    @Override
    public ThreeDigits apply(NumberRequest input) {

        int maxSize = 18;
        String tmpValue = DigitsExtractUtil.DECIMAL_FORMAT
                .format(Long.parseLong(input.getAbsoluteValue()))
                .substring(Math.max(maxSize - beginIndex, 0), maxSize - endIndex);

        return new ThreeDigits(Integer.parseInt(tmpValue));
    }
}
