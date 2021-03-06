package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

/**
 * Stratégie pour convertir l'élément des trilliards d'une {@link ThreeDigitsCollection} en chaine de caractères
 */
public class TrilliardConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public TrilliardConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean test(ThreeDigitsCollection collection) {
        return collection.trilliards().isPresent();
    }

    @Override
    public String apply(ThreeDigitsCollection collection) {

        return templateEngine.processTrilliard(collection.trilliards().orElseThrow(IllegalArgumentException::new));
    }
}
