package com.example.converter.v2;

import java.util.List;

/**
 * an implementation of {@link TranslateStrategy} for the english long scale metric
 */
class EnglishLongScaleTranslateStrategyImpl implements TranslateStrategy {

    @Override
    public WordResponse convertNumber(NumberRequest number) {

        if (number.isZero()) {
            return WordResponse.zeroWordResponse();
        }

        List<EnglishLongScaleMetric> converters = EnglishPrefixListFactory.get(number.size());

        StringBuilder output = new StringBuilder();

        for (EnglishLongScaleMetric entry : converters) {
            output.append(entry.translate(number));
        }

        return ImmutableWordResponse.builder().value(output.toString().trim()).build();
    }
}
