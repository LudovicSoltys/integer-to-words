package com.example.converter.v1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/** see {@link DigitsExtractUtil#units(Integer)}*/
class DigitsExtractUtilUnitsTest {

    @ParameterizedTest
    @MethodSource("utilShouldExtractDigits")
    void shouldReturnExpectedString(Integer value, Integer expectedHundred, Integer expectedTen, Integer expectedUnit) {

        // given

        // when
        ThreeDigits result = DigitsExtractUtil.units(value);

        // then
        Assertions.assertThat(result.getHundred()).isEqualTo(expectedHundred);
        Assertions.assertThat(result.getTen()).isEqualTo(expectedTen);
        Assertions.assertThat(result.getUnit()).isEqualTo(expectedUnit);
    }

    /**
     * @link https://en.wikipedia.org/wiki/English_numerals
     *
     * @return a sample of data
     */
    private static Stream<Arguments> utilShouldExtractDigits() {
        return Stream.of(
                Arguments.of(TestUtil.randomInt(0, 999999) * 1000, "0", "0", "0"),
                Arguments.of(123456789, "7", "8", "9")
        );
    }
}