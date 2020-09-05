package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

public class NegativeSignConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public NegativeSignConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean check(ThreeDigitsCollection collection) {
        return collection.isNegative();
    }

    @Override
    public String convert(ThreeDigitsCollection collection) {
        return templateEngine.processNegativeSign();
    }
}
