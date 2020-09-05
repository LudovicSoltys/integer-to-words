package com.example.converter.v2.english;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.function.Function;

/**
 * an implementation of {@link Function} that converts a {@link ThreeDigits} into an english {@link String} of numbers
 */
class EnglishThreeDigitsFunction implements Function<ThreeDigits, String> {

    private final String suffix;

    /** association of numbers between 0 and 19 to their english word */
    private static final Map<Integer, String> zeroToNineteen = ImmutableMap
            .<Integer, String>builder()
            .put(0, "")
            .put(1, "one")
            .put(2, "two")
            .put(3, "three")
            .put(4, "four")
            .put(5, "five")
            .put(6, "six")
            .put(7, "seven")
            .put(8, "eight")
            .put(9, "nine")
            .put(10, "ten")
            .put(11, "eleven")
            .put(12, "twelve")
            .put(13, "thirteen")
            .put(14, "fourteen")
            .put(15, "fifteen")
            .put(16, "sixteen")
            .put(17, "seventeen")
            .put(18, "eighteen")
            .put(19, "nineteen")
            .build();

    /** association of numbers between 0 and 9 to their english word */
    private static final Map<Integer, String> zeroToNine = ImmutableMap
            .<Integer, String>builder()
            .put(0, "")
            .put(1, "one")
            .put(2, "two")
            .put(3, "three")
            .put(4, "four")
            .put(5, "five")
            .put(6, "six")
            .put(7, "seven")
            .put(8, "eight")
            .put(9, "nine")
            .build();

    /** association of tens to their english word */
    private static final Map<Integer, String> tens = ImmutableMap
            .<Integer, String>builder()
            .put(2, "twenty")
            .put(3, "thirty")
            .put(4, "forty")
            .put(5, "fifty")
            .put(6, "sixty")
            .put(7, "seventy")
            .put(8, "eighty")
            .put(9, "ninety")
            .build();

    public EnglishThreeDigitsFunction(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String apply(ThreeDigits number) {

        if (number.isZero()) {
            return "";
        }

        String result;

        if (number.has2LastDigitsLowerThan20()) {
            result = zeroToNineteen.get(number.getTenAndUnit());
        } else {
            result = zeroToNine.get(number.getUnit());

            result = tens.get(number.getTen()) + (result.isEmpty() ? "" : "-" + result);
        }

        if (number.getHundred() != 0) {
            result = zeroToNine.get(number.getHundred()) + " hundred" + (result.isEmpty() ? "" : " " + result);
        }

        return (result + " " + suffix).trim();
    }
}
