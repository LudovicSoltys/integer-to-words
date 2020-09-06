package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

public class UnitConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public UnitConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean test(ThreeDigitsCollection collection) {
        return collection.units().isPresent();
    }

    @Override
    public String apply(ThreeDigitsCollection collection) {

        return templateEngine.processUnit(collection.units().get());
    }
}
