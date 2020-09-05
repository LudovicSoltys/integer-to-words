package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;

public class MilliardConverter extends AbstractConverter implements ThreeDigitsCollectionConverter {

    public MilliardConverter(EnglishTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public boolean check(ThreeDigitsCollection collection) {
        return collection.milliards().isPresent();
    }

    @Override
    public String convert(ThreeDigitsCollection collection) {
        return templateEngine.processMilliard(collection.milliards());
    }
}
