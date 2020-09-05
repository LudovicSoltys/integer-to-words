package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

public class ZeroEnglishNumberConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public ZeroEnglishNumberConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean check(ThreeDigitsCollection collection) {
        return collection.isZero();
    }

    @Override
    public String convert(ThreeDigitsCollection collection) {

        return templateEngine.processZero();
    }
}
