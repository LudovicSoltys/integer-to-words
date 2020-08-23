package com.example.converter.v2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberToThreeDigitsFunctionApplyTest {

    private NumberToThreeDigitsFunction subject;

    @ParameterizedTest
    @MethodSource("converterShouldTranslateIntegerIntoString")
    public void should_apply_function(String value, int index, ThreeDigits expectedResult) {

        // given
        subject = new NumberToThreeDigitsFunction(index);

        NumberRequest input = new NumberRequest(value);

        // when
        ThreeDigits result = subject.apply(input);

        // then
        Assertions.assertThat(result.isZero()).isEqualTo(false);
        Assertions.assertThat(result.getHundred()).isEqualTo(expectedResult.getHundred());
        Assertions.assertThat(result.getTen()).isEqualTo(expectedResult.getTen());
        Assertions.assertThat(result.getUnit()).isEqualTo(expectedResult.getUnit());
    }

    /**
     * @link https://en.wikipedia.org/wiki/English_numerals
     *
     * @return a sample of data
     */
    private static Stream<Arguments> converterShouldTranslateIntegerIntoString() {
        return Stream.of(
                Arguments.of("234", 0, new ThreeDigits(234)),
                Arguments.of("12345", 3, new ThreeDigits(12)),
                Arguments.of("12345", 0, new ThreeDigits(345)),
                Arguments.of("1000000000000000000234", 0, new ThreeDigits(234)),
                Arguments.of("1000000000000000012345", 3, new ThreeDigits(12)),
                Arguments.of("1000000000000012345000", 6, new ThreeDigits(12)),
                Arguments.of("10000000000000012345000", 6, new ThreeDigits(12)),
                Arguments.of("1000000000000000012345", 0, new ThreeDigits(345))
        );
    }
}