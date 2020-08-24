package com.example.converter.v2;

import org.junit.jupiter.api.RepeatedTest;
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
@WebMvcTest(ExtraLongNumberToWordsConversionRestService.class)
class ExtraLongNumberToWordsConversionRestServiceConvertPerformanceTest {

    @Autowired
    private MockMvc mockMvc;

    @RepeatedTest(5)
    public void shouldReturnInputTranslatedIntoWords() throws Exception {

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
                .perform(MockMvcRequestBuilders.get("/api/v2/convert/{value}", value))
                .andDo(MockMvcResultHandlers.print());
    }
}