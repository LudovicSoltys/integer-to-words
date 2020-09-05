package com.example.converter.v2.english;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/** @see EnglishNumber */
class EnglishNumberIntantiateTest {

    @ParameterizedTest
    @MethodSource("converterShouldTranslateIntegerIntoString")
    void should_instantiate_when_input_is_made_with_digits_only(String input, boolean expectedZero, int expectedSize) {

        // given


        // when
        EnglishNumber result = new EnglishNumber(input);

        // then
        Assertions.assertThat(result.isZero()).isEqualTo(expectedZero);
        Assertions.assertThat(result.length()).isEqualTo(expectedSize);
    }

    /**
     * @link https://en.wikipedia.org/wiki/English_numerals
     *
     * @return a sample of data
     */
    private static Stream<Arguments> converterShouldTranslateIntegerIntoString() {
        return Stream.of(
                Arguments.of("0", true, 1),
                Arguments.of("00", true, 1), // reduced to "0"
                Arguments.of("00000000000", true, 1),  // reduced to "0"
                Arguments.of("245", false, 3),
                Arguments.of("000245", false, 3),
                Arguments.of("1245", false, 4),
                Arguments.of("10245", false, 5),
                Arguments.of("75", false, 2),
                Arguments.of("75000", false, 5),
                Arguments.of("7000000", false, 7),
                Arguments.of("07000000", false, 7),
                Arguments.of("7483647", false, 7),
                Arguments.of("00007483647", false, 7),
                Arguments.of("100007483647", false, 12),
                Arguments.of("9223372036854775807", false, 19),
                Arguments.of("10223372036854775807", false, 20)
        );
    }
}