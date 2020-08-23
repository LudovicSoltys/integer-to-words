package com.example.converter.v2;

import java.util.function.Function;

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
        String tmpValue;
        int size = input.size();
        int maxSize = 18;
        if (size < maxSize) {

            tmpValue = DigitsExtractUtil.DECIMAL_FORMAT
                    .format(Integer.parseInt(input.getValue()))
                    .substring(Math.max(maxSize - beginIndex, 0), maxSize - endIndex);
        } else {

            String value = input.getValue();
            tmpValue = DigitsExtractUtil.DECIMAL_FORMAT
                    .format(Integer.parseInt(value.substring(size - beginIndex, size - endIndex)));
        }

        return new ThreeDigits(Integer.parseInt(tmpValue));
    }
}
