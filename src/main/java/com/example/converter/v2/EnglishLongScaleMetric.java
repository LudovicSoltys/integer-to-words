package com.example.converter.v2;

import java.util.function.Function;

/**
 * an enumeration for all the managed names
 *
 * the elements shall be declared in reverse order of powers of ten, in order to avoid the sorting for the list made in
 * {@link EnglishPrefixListFactory}
 *
 * @link https://en.wikipedia.org/wiki/Metric_prefix
 */
enum EnglishLongScaleMetric {

    // 10^24
    QUADRILLION(new OverLongNumberToThreeDigitsFunction(24), 24, "quadrillion"),

    // 10^21
    TRILLIARD(new OverLongNumberToThreeDigitsFunction(21), 21, "trilliard"),

    // 10^18
    TRILLION(new OverLongNumberToThreeDigitsFunction(18), 18, "trillion"),

    // 10^15
    BILLIARD(new NumberToThreeDigitsFunction(15), 15, "billiard"),

    // 10^12
    BILLION(new NumberToThreeDigitsFunction(12), 12, "billion"),

    // 10^9
    MILLARD(new NumberToThreeDigitsFunction(9), 9, "milliard"),

    // 10^6
    MILLION(new NumberToThreeDigitsFunction(6), 6, "million"),

    // 10^3
    THOUSAND(new NumberToThreeDigitsFunction(3), 3, "thousand"),

    // 10^0
    ONE(new NumberToThreeDigitsFunction(0), 0, "");

    private final Function<NumberRequest, ThreeDigits> threeDigitsFunction;

    private final int minDigitsCount;

    private final Function<ThreeDigits, String> translator;

    EnglishLongScaleMetric(Function<NumberRequest, ThreeDigits> function, int minDigitsCount, String suffix) {
        this.threeDigitsFunction = function;

        this.minDigitsCount = minDigitsCount;

        translator = new EnglishThreeDigitsFunction(suffix);
    }

    int getMinDigitsCount() {
        return minDigitsCount;
    }

    /**
     *
     * @param input a {@link NumberRequest}
     * @return the translation of the input
     */
    String translate(NumberRequest input) {

        ThreeDigits number = threeDigitsFunction.apply(input);

        if (number.isZero()) {
            return "";
        } else {
            return translator.apply(number);
        }
    }
}
