package com.example.converter.v3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AppV3WebConfig.class })
@AutoConfigureMockMvc
class TranslationControllerInstantiateTest {

    @Autowired
    private TranslationController translationController;

    @Test
    void configurationShouldInstantiateController() throws Exception {

        // given

        // when

        // then
        Assertions.assertThat(translationController).isNotNull().isInstanceOf(TranslationController.class);
    }
}