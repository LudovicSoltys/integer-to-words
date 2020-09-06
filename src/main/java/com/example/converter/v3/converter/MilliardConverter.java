package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

/**
 * Stratégie pour convertir l'élément des milliards d'une {@link ThreeDigitsCollection} en chaine de caractères
 */
public class MilliardConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public MilliardConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean test(ThreeDigitsCollection collection) {
        return collection.milliards().isPresent();
    }

    @Override
    public String apply(ThreeDigitsCollection collection) {

        return templateEngine.processMilliard(collection.milliards().orElseThrow(IllegalArgumentException::new));
    }
}
