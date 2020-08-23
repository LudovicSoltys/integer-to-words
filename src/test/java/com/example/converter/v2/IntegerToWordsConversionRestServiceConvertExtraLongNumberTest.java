package com.example.converter.v2;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(IntegerToWordsConversionRestService.class)
class IntegerToWordsConversionRestServiceConvertExtraLongNumberTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnInputTranslatedIntoWords() throws Exception {

        // given
        String input = "111223372036854775807";

        // when
        ResultActions result = when(input);

        // then
        result
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.value").value("one hundred eleven trillion two hundred twenty-three billiard three hundred seventy-two billion thirty-six milliard eight hundred fifty-four million seven hundred seventy-five thousand eight hundred seven"));

    }

    private ResultActions when(String value) throws Exception {
        return mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v2/convert/{value}", value))
                .andDo(MockMvcResultHandlers.print());
    }
}