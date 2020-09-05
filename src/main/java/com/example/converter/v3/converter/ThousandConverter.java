package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

public class ThousandConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public ThousandConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean check(ThreeDigitsCollection collection) {
        return collection.thousands().isPresent();
    }

    @Override
    public String convert(ThreeDigitsCollection collection) {
        return templateEngine.processThousand(collection.thousands());
    }
}
