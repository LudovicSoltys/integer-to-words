package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

/**
 * Stratégie pour convertir l'élément des millions d'une {@link ThreeDigitsCollection} en chaine de caractères
 */
public class MillionConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public MillionConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean test(ThreeDigitsCollection collection) {
        return collection.millions().isPresent();
    }

    @Override
    public String apply(ThreeDigitsCollection collection) {

        return templateEngine.processMillion(collection.millions().orElseThrow(IllegalArgumentException::new));
    }
}
