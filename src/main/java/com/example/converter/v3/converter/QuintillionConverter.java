package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

public class QuintillionConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public QuintillionConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean test(ThreeDigitsCollection collection) {
        return collection.quintillions().isPresent();
    }

    @Override
    public String apply(ThreeDigitsCollection collection) {

        return templateEngine.processQuintillion(collection.quintillions().get());
    }
}
