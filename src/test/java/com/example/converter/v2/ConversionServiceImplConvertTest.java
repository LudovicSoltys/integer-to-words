package com.example.converter.v2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/** @see ConversionServiceImpl#convertNumber(NumberRequest)  */
class ConversionServiceImplConvertTest {

    private final ConversionServiceImpl subject = new ConversionServiceImpl();

    @ParameterizedTest
    @MethodSource("converterShouldTranslateIntegerIntoString")
    void shouldReturnExpectedString(String value, String expected) {

        // given
        NumberRequest input = new NumberRequest(value);

        // when
        WordResponse result = subject.convertNumber(input);

        // then
        Assertions.assertThat(result.getValue()).isEqualTo(expected);
    }

    /**
     * @link https://en.wikipedia.org/wiki/English_numerals
     *
     * @return a sample of data
     *
     * Some examples :
     *         9,223,372,036,854,775,807   {@link Long#MAX_VALUE}
     * 1 000 000 000 000 000 000 000 000 	Quadrillion
     *     1 000 000 000 000 000 000 000 	Trilliard
     *         1 000 000 000 000 000 000 	Trillion
     *             1 000 000 000 000 000 	Billiard
     *                 1 000 000 000 000 	Billion
     *                     1 000 000 000 	Milliard
     *                         1 000 000 	Million
     *                             1 000 	Millier
     *                               100 	Centaine
     *                                10 	Dizaine
     *                                 1 	Unité
     *
     */
    private static Stream<Arguments> converterShouldTranslateIntegerIntoString() {
        return Stream.of(
                Arguments.of("0", "zero"),
                Arguments.of("245", "two hundred forty-five"),
                Arguments.of("1245", "one thousand two hundred forty-five"),
                Arguments.of("10245", "ten thousand two hundred forty-five"),
                Arguments.of("75", "seventy-five"),
                Arguments.of("75000", "seventy-five thousand"),
                Arguments.of("7000000", "seven million"),
                Arguments.of("7483647", "seven million four hundred eighty-three thousand six hundred forty-seven"),
                Arguments.of(Long.MAX_VALUE + "", "nine trillion two hundred twenty-three billiard three hundred seventy-two billion thirty-six milliard eight hundred fifty-four million seven hundred seventy-five thousand eight hundred seven"),
                Arguments.of("111223372036854775807", "one hundred eleven trillion two hundred twenty-three billiard three hundred seventy-two billion thirty-six milliard eight hundred fifty-four million seven hundred seventy-five thousand eight hundred seven")
        );
    }
}