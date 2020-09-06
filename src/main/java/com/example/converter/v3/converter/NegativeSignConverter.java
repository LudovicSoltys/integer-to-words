package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

/**
 * Stratégie pour convertir le symbole négatif en chaine de caractères
 */
public class NegativeSignConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public NegativeSignConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean test(ThreeDigitsCollection collection) {
        return collection.isNegative();
    }

    @Override
    public String apply(ThreeDigitsCollection collection) {
        return templateEngine.processNegativeSign();
    }
}
