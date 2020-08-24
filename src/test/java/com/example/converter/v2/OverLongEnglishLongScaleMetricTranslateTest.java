package com.example.converter.v2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/** @see  OverLongEnglishLongScaleMetric#translate(NumberRequest) */
class OverLongEnglishLongScaleMetricTranslateTest {

    @ParameterizedTest
    @MethodSource("converterShouldTranslateIntegerIntoString")
    public void subject_should_translate_request_into_string(OverLongEnglishLongScaleMetric subject, NumberRequest inputValue, String expectedValue) {

        // given

        // when
        String result = subject.translate(inputValue);

        // then
        Assertions.assertThat(result).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> converterShouldTranslateIntegerIntoString() {
        return Stream.of(
                Arguments.of(OverLongEnglishLongScaleMetric.ONE,         new NumberRequest("1000000000000000000000000"), ""),
                Arguments.of(OverLongEnglishLongScaleMetric.ONE,         new NumberRequest("10000000000000000000000001"), "one"),
                Arguments.of(OverLongEnglishLongScaleMetric.THOUSAND,    new NumberRequest("10000000000000000000000001"), ""),
                Arguments.of(OverLongEnglishLongScaleMetric.THOUSAND,    new NumberRequest("10000000000000000000001000"), "one thousand"),
                Arguments.of(OverLongEnglishLongScaleMetric.MILLION,     new NumberRequest("10000000000000000000000001"), ""),
                Arguments.of(OverLongEnglishLongScaleMetric.MILLION,     new NumberRequest("10000000000000000001000000"), "one million"),
                Arguments.of(OverLongEnglishLongScaleMetric.MILLARD,     new NumberRequest("10000000000000000000000001"), ""),
                Arguments.of(OverLongEnglishLongScaleMetric.MILLARD,     new NumberRequest("10000000000000001000000000"), "one milliard"),
                Arguments.of(OverLongEnglishLongScaleMetric.BILLION,     new NumberRequest("10000000000000000000000001"), ""),
                Arguments.of(OverLongEnglishLongScaleMetric.BILLION,     new NumberRequest("10000000000001000000000000"), "one billion"),
                Arguments.of(OverLongEnglishLongScaleMetric.BILLIARD,    new NumberRequest("10000000000000000000000001"), ""),
                Arguments.of(OverLongEnglishLongScaleMetric.BILLIARD,    new NumberRequest("10000000001000000000000000"), "one billiard"),
                Arguments.of(OverLongEnglishLongScaleMetric.TRILLION,    new NumberRequest("10000000000000000000000001"), ""),
                Arguments.of(OverLongEnglishLongScaleMetric.TRILLION,    new NumberRequest("10000001000000000000000000"), "one trillion"),
                Arguments.of(OverLongEnglishLongScaleMetric.TRILLIARD,   new NumberRequest("10000000000000000000000001"), ""),
                Arguments.of(OverLongEnglishLongScaleMetric.TRILLIARD,   new NumberRequest("1000000000000000000000"), "one trilliard"),
                Arguments.of(OverLongEnglishLongScaleMetric.QUADRILLION, new NumberRequest("00000000000000000000000001"), ""),
                Arguments.of(OverLongEnglishLongScaleMetric.QUADRILLION, new NumberRequest("1000000000000000000000000"), "one quadrillion")
        );
    }
}