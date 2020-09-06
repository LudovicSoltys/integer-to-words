package com.example.converter.v3.util;

import com.example.converter.v3.EnglishNumber;
import com.example.converter.v3.util.TextSplitterUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class TextSplitterUtilSplitTest {

    @ParameterizedTest
    @MethodSource("data")
    void should_split_string_in_equal_parts(String value, int count, Integer expectedSize, List<Integer> expectedContent) {

        // given
        EnglishNumber input = EnglishNumber.of(value);

        // when
        List<String> result = TextSplitterUtil.split(input, count);

        // then
        Assertions.assertThat(result)
                .hasSize(expectedSize)
                .isEqualTo(expectedContent);
    }

    /**
     * @link https://en.wikipedia.org/wiki/English_numerals
     *
     * @return a sample of data
     */
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(                 "234", 3, 1, Collections.singletonList("234")),
                Arguments.of(                 "234", 1, 3, Arrays.asList("4", "3", "2")),
                Arguments.of(                 "234", 2, 2, Arrays.asList("34", "2")),
                Arguments.of(                "1234", 3, 2, Arrays.asList("234", "1")),
                Arguments.of(            "12345678", 3, 3, Arrays.asList("678", "345", "12")),
                Arguments.of(  "234567890123456789", 3, 6, Arrays.asList("789", "456", "123", "890", "567", "234")),
                Arguments.of("12345678901234567890", 3, 7, Arrays.asList("890", "567", "234", "901", "678", "345", "12"))
        );
    }
}