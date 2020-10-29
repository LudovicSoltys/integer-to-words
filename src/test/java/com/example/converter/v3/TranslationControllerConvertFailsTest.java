package com.example.converter.v3;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(AppV3WebConfig.class)
class TranslationControllerConvertFailsTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnInputTranslatedIntoWords() throws Exception {

        // given
        String input = "blabla";

        // when
        ResultActions result = when(input);

        // then
        result
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    private ResultActions when(String value) throws Exception {
        return mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v3/convert/{value}", value))
                .andDo(MockMvcResultHandlers.print());
    }
}