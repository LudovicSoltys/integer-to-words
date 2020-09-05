package com.example.converter.v2.english;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/** @see  BigEnglishLongScaleMetric#translate(EnglishNumber) */
class BigEnglishLongScaleMetricTranslateTest {

    @ParameterizedTest
    @MethodSource("converterShouldTranslateIntegerIntoString")
    void subject_should_translate_request_into_string(BigEnglishLongScaleMetric subject, EnglishNumber inputValue, String expectedValue) {

        // given

        // when
        String result = subject.translate(inputValue);

        // then
        Assertions.assertThat(result).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> converterShouldTranslateIntegerIntoString() {
        return Stream.of(
                Arguments.of(BigEnglishLongScaleMetric.ONE,         new EnglishNumber("1000000000000000000000000"), ""),
                Arguments.of(BigEnglishLongScaleMetric.ONE,         new EnglishNumber("10000000000000000000000001"), "one"),
                Arguments.of(BigEnglishLongScaleMetric.THOUSAND,    new EnglishNumber("10000000000000000000000001"), ""),
                Arguments.of(BigEnglishLongScaleMetric.THOUSAND,    new EnglishNumber("10000000000000000000001000"), "one thousand"),
                Arguments.of(BigEnglishLongScaleMetric.MILLION,     new EnglishNumber("10000000000000000000000001"), ""),
                Arguments.of(BigEnglishLongScaleMetric.MILLION,     new EnglishNumber("10000000000000000001000000"), "one million"),
                Arguments.of(BigEnglishLongScaleMetric.MILLARD,     new EnglishNumber("10000000000000000000000001"), ""),
                Arguments.of(BigEnglishLongScaleMetric.MILLARD,     new EnglishNumber("10000000000000001000000000"), "one milliard"),
                Arguments.of(BigEnglishLongScaleMetric.BILLION,     new EnglishNumber("10000000000000000000000001"), ""),
                Arguments.of(BigEnglishLongScaleMetric.BILLION,     new EnglishNumber("10000000000001000000000000"), "one billion"),
                Arguments.of(BigEnglishLongScaleMetric.BILLIARD,    new EnglishNumber("10000000000000000000000001"), ""),
                Arguments.of(BigEnglishLongScaleMetric.BILLIARD,    new EnglishNumber("10000000001000000000000000"), "one billiard"),
                Arguments.of(BigEnglishLongScaleMetric.TRILLION,    new EnglishNumber("10000000000000000000000001"), ""),
                Arguments.of(BigEnglishLongScaleMetric.TRILLION,    new EnglishNumber("10000001000000000000000000"), "one trillion"),
                Arguments.of(BigEnglishLongScaleMetric.TRILLIARD,   new EnglishNumber("10000000000000000000000001"), ""),
                Arguments.of(BigEnglishLongScaleMetric.TRILLIARD,   new EnglishNumber("1000000000000000000000"), "one trilliard"),
                Arguments.of(BigEnglishLongScaleMetric.QUADRILLION, new EnglishNumber("00000000000000000000000001"), ""),
                Arguments.of(BigEnglishLongScaleMetric.QUADRILLION, new EnglishNumber("1000000000000000000000000"), "one quadrillion")
        );
    }
}