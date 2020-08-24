package com.example.converter.v2;

import java.util.Optional;
import java.util.function.Function;

/**
 * an enumeration for all the managed names
 *
 * the elements shall be declared in reverse order of powers of ten, in order to avoid the sorting for the list made in
 * {@link EnglishPrefixListFactory}
 *
 * @link https://en.wikipedia.org/wiki/Metric_prefix
 */
enum OverLongEnglishLongScaleMetric implements EnglishTranslator {

    // 10^24
    QUADRILLION(24, "quadrillion"),

    // 10^21
    TRILLIARD(21, "trilliard"),

    // 10^18
    TRILLION(18, "trillion"),

    // 10^15
    BILLIARD(15, "billiard"),

    // 10^12
    BILLION(12, "billion"),

    // 10^9
    MILLARD(9, "milliard"),

    // 10^6
    MILLION(6, "million"),

    // 10^3
    THOUSAND(3, "thousand"),

    // 10^0
    ONE(0, "");

    private final Function<NumberRequest, ThreeDigits> threeDigitsFunction;

    private final Function<ThreeDigits, String> translator;

    OverLongEnglishLongScaleMetric(int powerOfTen, String suffix) {
        if (powerOfTen < 18) {
            threeDigitsFunction = new NumberToThreeDigitsFunction(powerOfTen);
        } else {
            threeDigitsFunction = new OverLongNumberToThreeDigitsFunction(powerOfTen);
        }

        translator = new EnglishThreeDigitsFunction(suffix);
    }

    /**
     *
     * @param input a {@link NumberRequest}
     * @return the translation of the input
     */
    @Override
    public String translate(NumberRequest input) {

        return Optional.of(input).map(threeDigitsFunction).map(translator).orElse("");
    }
}
