package com.example.converter.v2;

import com.example.converter.v2.english.EnglishNumber;
import com.example.converter.v2.english.EnglishPrefixListFactory;

import java.util.stream.Collectors;

/**
 * default implementation for {@link ExtraLongConversionService}
 */
public class ExtraLongExtraLongConversionServiceImpl implements ExtraLongConversionService {

    @Override
    public WordResponse convertNumber(String input) {

        EnglishNumber number = EnglishNumber.englishNumber(input);

        if (number.isZero()) {
            return WordResponse.zeroWordResponse();
        }

        String output = EnglishPrefixListFactory
                .get(number.length())
                .get()
                .stream()
                .map(translator -> translator.translate(number))
                .collect(Collectors.joining(" "));

        return ImmutableWordResponse.builder()
                .value((number.isLowerThanZero() ? "minus " : "") + output.trim())
                .build();
    }
}
