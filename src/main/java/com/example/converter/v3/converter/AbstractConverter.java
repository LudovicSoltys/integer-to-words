package com.example.converter.v3.converter;

import com.example.converter.v3.util.templating.EnglishTemplateEngine;

/**
 *
 */
public abstract class AbstractConverter {

    protected final EnglishTemplateEngine templateEngine;

    public AbstractConverter(EnglishTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }
}
