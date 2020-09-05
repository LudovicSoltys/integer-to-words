package com.example.converter.v2.english;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/** @see BigNumberToThreeDigitsFunction#apply(EnglishNumber) */
class BigNumberToThreeDigitsFunctionApplyTest {

    private BigNumberToThreeDigitsFunction subject;

    @ParameterizedTest
    @MethodSource("converterShouldTranslateIntegerIntoString")
    void should_apply_function(String value, int endIndex, ThreeDigits expectedResult) {

        // given
        subject = new BigNumberToThreeDigitsFunction(endIndex);

        EnglishNumber input = new EnglishNumber(value);

        // when
        ThreeDigits result = subject.apply(input);

        // then
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
                Arguments.of(        "9223372036854775807", 18, ThreeDigits.threeDigits(9)),
                Arguments.of(  "0000009223372036854775807", 18, ThreeDigits.threeDigits(9)),
                Arguments.of( "10000009223372036854775807", 18, ThreeDigits.threeDigits(9)),
                Arguments.of(        "9223372036854775807", 21, ThreeDigits.threeDigits(0)),
                Arguments.of(       "92233720368547758070", 18, ThreeDigits.threeDigits(92)),
                Arguments.of(      "922337203685477580700", 18, ThreeDigits.threeDigits(922)),
                Arguments.of("223372036854775807000000000", 18, ThreeDigits.threeDigits(36))
            );
    }
}