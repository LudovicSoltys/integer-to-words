package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

public class TrillionConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public TrillionConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean test(ThreeDigitsCollection collection) {
        return collection.trillions().isPresent();
    }

    @Override
    public String apply(ThreeDigitsCollection collection) {
        return templateEngine.processTrillion(collection.trillions().get());
    }
}
