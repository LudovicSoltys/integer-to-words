package com.example.converter.v3;

import com.example.converter.v3.util.templating.EnglishTemplateEngine;

import java.util.function.Function;

/**
 * default implementation of {@link TranslationService}
 */
public class TranslationServiceImpl implements TranslationService {

    private final EnglishTemplateEngine templateEngine;

    private final Function<ThreeDigitsCollection, String> converter;

    public TranslationServiceImpl(EnglishTemplateEngine templateEngine, Function<ThreeDigitsCollection, String> converter) {
        this.templateEngine = templateEngine;
        this.converter = converter;
    }

    @Override
    public Maybe<String> translateNumber(EnglishNumber value) {

        return value
                .map(
                        number -> ThreeDigitsCollection.instance(number).map(converter),
                        stringOptional -> templateEngine.processNegativeSign() + " " + stringOptional
                )
                .map(Maybe::success)
                .orElseGet(() -> Maybe.success(templateEngine.processZero()));
    }
}
