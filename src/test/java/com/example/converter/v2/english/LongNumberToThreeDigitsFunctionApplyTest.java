package com.example.converter.v2.english;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.example.converter.v2.english.ThreeDigits.threeDigits;

/** @see LongNumberToThreeDigitsFunction#apply(EnglishNumber) */
class LongNumberToThreeDigitsFunctionApplyTest {

    private LongNumberToThreeDigitsFunction subject;

    @ParameterizedTest
    @MethodSource("converterShouldTranslateIntegerIntoString")
    void should_apply_function(String value, int index, ThreeDigits expectedResult) {

        // given
        subject = new LongNumberToThreeDigitsFunction(index);

        EnglishNumber input = new EnglishNumber(value);

        // when
        ThreeDigits result = subject.apply(input);

        // then
        Assertions.assertThat(result.isZero()).isFalse();
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
                Arguments.of("234", 0, threeDigits(234)),
                Arguments.of("12345", 3, threeDigits(12)),
                Arguments.of("12345", 0, threeDigits(345)),
                Arguments.of("1000000000000000000234", 0, threeDigits(234)),
                Arguments.of("1000000000000000012345", 3, threeDigits(12)),
                Arguments.of("1000000000000012345000", 6, threeDigits(12)),
                Arguments.of("10000000000000012345000", 6, threeDigits(12)),
                Arguments.of("1000000000000000012345", 0, threeDigits(345))
        );
    }
}