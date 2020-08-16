package com.example.converter.service;

import com.example.converter.domain.ThreeDigits;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/** see {@link EnglishThreeDigitsFunction#apply(ThreeDigits)} */
class EnglishThreeDigitsFunctionApplyTest {

    private final EnglishThreeDigitsFunction subject = new EnglishThreeDigitsFunction();

    @ParameterizedTest
    @MethodSource("converterShouldTranslateIntegerIntoString")
    void shouldReturnExpectedString(Integer value, String expected) {

        // given
        ThreeDigits input = new ThreeDigits(value);

        // when
        String result = subject.apply(input);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    /**
     * @return a sample of data
     */
    private static Stream<Arguments> converterShouldTranslateIntegerIntoString() {
        return Stream.of(
                Arguments.of("0", ""),
                Arguments.of("5", "five"),
                Arguments.of("50", "fifty"),
                Arguments.of("75", "seventy-five"),
                Arguments.of("100", "one hundred"),
                Arguments.of("112", "one hundred twelve"),
                Arguments.of("245", "two hundred forty-five")
        );
    }
}