package com.example.converter.service;

import com.example.converter.domain.NumberRequest;
import com.example.converter.domain.WordResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

class ConversionServiceImplConvertTest {

    private final ConversionServiceImpl subject = new ConversionServiceImpl();

    @ParameterizedTest
    @MethodSource("converterShouldTranslateIntegerIntoString")
    void shouldReturnExpectedString(Integer value, String expected) {

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
     */
    private static Stream<Arguments> converterShouldTranslateIntegerIntoString() {
        return Stream.of(
                Arguments.of("0", "zero"),
                Arguments.of("245", "two hundred and forty-five"),
                Arguments.of("1245", "one thousand two hundred and forty-five"),
                Arguments.of("10245", "ten thousand two hundred and forty-five"),
                Arguments.of("75", "seventy-five"),
                Arguments.of("75000", "seventy-five thousand"),
                Arguments.of("7000000", "seven million"),
                Arguments.of("7483647", "seven million four hundred and eighty-three thousand six hundred and forty-seven")
        );
    }
}