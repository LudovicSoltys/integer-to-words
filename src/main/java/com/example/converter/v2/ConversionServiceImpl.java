package com.example.converter.v2;

/**
 * default implementation for {@link ConversionService}
 */
public class ConversionServiceImpl implements ConversionService {

    @Override
    public WordResponse convertNumber(NumberRequest number) {

        TranslateStrategy strategy = new EnglishLongScaleTranslateStrategyImpl();

        return strategy.convertNumber(number);
    }
}
