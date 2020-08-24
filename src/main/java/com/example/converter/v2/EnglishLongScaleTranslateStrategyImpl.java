package com.example.converter.v2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * an implementation of {@link TranslateStrategy} for the english long scale metric
 */
class EnglishLongScaleTranslateStrategyImpl implements TranslateStrategy {

    @Override
    public WordResponse convertNumber(NumberRequest number) {

        if (number.isZero()) {
            return WordResponse.zeroWordResponse();
        }

        String output = EnglishPrefixListFactory
                .get(number.size())
                .get()
                .stream()
                .map(translator -> translator.translate(number))
                .collect(Collectors.joining(" "));

        return ImmutableWordResponse.builder().value(number.isLowerThanZero() ? "minus " : "" + output.trim()).build();
    }
}
