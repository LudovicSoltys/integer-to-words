package com.example.converter.v2;

/**
 * default implementation for {@link ConversionService}
 */
public class ConversionServiceImpl implements ConversionService {

    private final TranslateStrategy strategy = new EnglishLongScaleTranslateStrategyImpl();

    @Override
    public WordResponse convertNumber(NumberRequest number) {

        return strategy.convertNumber(number);
    }
}
