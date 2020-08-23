package com.example.converter.v2;

import java.util.List;

/**
 * an implmentation of {@link TranslateStrategy} for the english long scale metric
 */
class EnglishLongScaleTranslateStrategyImpl implements TranslateStrategy {

    @Override
    public WordResponse convertNumber(NumberRequest number) {

        if (number.isZero()) {
            return WordResponse.zeroWordResponse();
        }

        List<EnglishLongScaleMetricPrefix> converters = EnglishPrefixListFactory.get(number.size());

        StringBuilder output = new StringBuilder();

        for (EnglishLongScaleMetricPrefix entry : converters) {
            output.append(entry.translate(number));
        }

        return ImmutableWordResponse.builder().value(output.toString().trim()).build();
    }
}
