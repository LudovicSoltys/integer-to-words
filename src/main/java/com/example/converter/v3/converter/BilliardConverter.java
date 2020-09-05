package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

public class BilliardConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public BilliardConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean check(ThreeDigitsCollection collection) {
        return collection.billiards().isPresent();
    }

    @Override
    public String convert(ThreeDigitsCollection collection) {
        return templateEngine.processBilliard(collection.billiards());
    }
}
