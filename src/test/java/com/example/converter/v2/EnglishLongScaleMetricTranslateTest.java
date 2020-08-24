package com.example.converter.v2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/** @see EnglishLongScaleMetric#translate(NumberRequest) */
class EnglishLongScaleMetricTranslateTest {

    @ParameterizedTest
    @MethodSource("converterShouldTranslateIntegerIntoString")
    public void should(EnglishLongScaleMetric subject, NumberRequest inputValue, String expectedValue) {

        // given

        // when
        String result = subject.translate(inputValue);

        // then
        Assertions.assertThat(result).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> converterShouldTranslateIntegerIntoString() {
        return Stream.of(
                Arguments.of(EnglishLongScaleMetric.ONE, new NumberRequest("1000"), ""),
                Arguments.of(EnglishLongScaleMetric.ONE, new NumberRequest("1"), "one"),
                Arguments.of(EnglishLongScaleMetric.THOUSAND, new NumberRequest("1000000"), ""),
                Arguments.of(EnglishLongScaleMetric.THOUSAND, new NumberRequest("1000"), "one thousand"),
                Arguments.of(EnglishLongScaleMetric.MILLION, new NumberRequest("1"), ""),
                Arguments.of(EnglishLongScaleMetric.MILLION, new NumberRequest("1000000"), "one million"),
                Arguments.of(EnglishLongScaleMetric.MILLARD, new NumberRequest("1"), ""),
                Arguments.of(EnglishLongScaleMetric.MILLARD, new NumberRequest("1000000000"), "one milliard"),
                Arguments.of(EnglishLongScaleMetric.BILLION, new NumberRequest("1"), ""),
                Arguments.of(EnglishLongScaleMetric.BILLION, new NumberRequest("1000000000000"), "one billion"),
                Arguments.of(EnglishLongScaleMetric.BILLIARD, new NumberRequest("1"), ""),
                Arguments.of(EnglishLongScaleMetric.BILLIARD, new NumberRequest("1000000000000000"), "one billiard")
        );
    }
}