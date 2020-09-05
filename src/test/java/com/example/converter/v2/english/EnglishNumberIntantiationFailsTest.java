package com.example.converter.v2.english;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/** @see EnglishNumber#englishNumber(String)  */
class EnglishNumberIntantiationFailsTest {

    @Test
    void should_throw_IllegalArgumentException_when_input_is_null() {

        // given
        String input = null;

        // when
        try {
            EnglishNumber.englishNumber(input);
        } catch (IllegalArgumentException exception) {
            Assertions.assertThat(exception.getMessage()).isEqualTo("Expect numbers only. Actual value is null");
        }
    }

    @Test
    void should_throw_IllegalArgumentException_when_input_is_not_made_with_digits_only() {

        // given
        String input = "x";

        // when
        try {
            EnglishNumber.englishNumber(input);
        } catch (IllegalArgumentException exception) {
            Assertions.assertThat(exception.getMessage()).isEqualTo("Expect numbers only. Actual value is x");
        }
    }
}