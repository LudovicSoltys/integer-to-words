package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

/**
 * Stratégie pour convertir l'élément des billions d'une {@link ThreeDigitsCollection} en chaine de caractères
 */
public class BillionConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public BillionConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean test(ThreeDigitsCollection collection) {
        return collection.billions().isPresent();
    }

    @Override
    public String apply(ThreeDigitsCollection collection) {

        return templateEngine.processBillion(collection.billions().orElseThrow(IllegalArgumentException::new));
    }
}
