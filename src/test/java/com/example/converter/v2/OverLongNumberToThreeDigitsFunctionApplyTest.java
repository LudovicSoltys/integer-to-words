package com.example.converter.v2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/** @see OverLongNumberToThreeDigitsFunction#apply(NumberRequest) */
class OverLongNumberToThreeDigitsFunctionApplyTest {

    private OverLongNumberToThreeDigitsFunction subject;

    @ParameterizedTest
    @MethodSource("converterShouldTranslateIntegerIntoString")
    public void should_apply_function(String value, int endIndex, ThreeDigits expectedResult) {

        // given
        subject = new OverLongNumberToThreeDigitsFunction(endIndex);

        NumberRequest input = new NumberRequest(value);

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
                Arguments.of(         "9223372036854775807", 18, new ThreeDigits(9)),
                Arguments.of(         "9223372036854775807", 21, new ThreeDigits(0)),
                Arguments.of(        "92233720368547758070", 18, new ThreeDigits(92)),
                Arguments.of(       "922337203685477580700", 18, new ThreeDigits(922)),
                Arguments.of("9223372036854775807000000000", 18, new ThreeDigits(36))
            );
    }
}