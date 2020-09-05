package com.example.converter.v3;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TranslationControllerConvertTest.TranslationControllerConvertTestConfig.class })
@AutoConfigureMockMvc
class TranslationControllerConvertTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnInputTranslatedIntoWords() throws Exception {

        // given
        Integer input = 245;

        // when
        ResultActions result = when(input);

        // then
        result
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.value").value("two hundred forty-five"));

    }

    private ResultActions when(Integer value) throws Exception {
        return mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v3/convert/{value}", value))
                .andDo(MockMvcResultHandlers.print());
    }

    @Configuration
    @Import(AppV3WebConfig.class)
    static class TranslationControllerConvertTestConfig {

        @Autowired
        private TranslationService translationService;
    }
}