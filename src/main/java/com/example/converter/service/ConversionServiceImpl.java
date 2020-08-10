package com.example.converter.service;

import com.example.converter.domain.ImmutableWordResponse;
import com.example.converter.domain.NumberRequest;
import com.example.converter.domain.ThreeDigits;
import com.example.converter.domain.WordResponse;

import java.util.function.Function;

/**
 * an implementation of {@link ConversionService}
 *
 * @link https://stackoverflow.com/questions/3911966/how-to-convert-number-to-words-in-java
 */
public class ConversionServiceImpl implements ConversionService {

    private final Function<ThreeDigits, String> function = new EnglishThreeDigitsFunction();

    @Override
    public WordResponse convertNumber(NumberRequest number) {

        String result = "";

        if (number.isZero()) {
            return WordResponse.zeroWordResponse();
        }

        if (number.hasMillions()) {
            result += function.apply(number.getMillions()) + " million ";
        }

        if (number.hasThousands()) {
            result += function.apply(number.getThousands()) + " thousand ";
        }

        result += function.apply(number.getUnits());

        // we trim the result, so as to avoid some unnecessary space that happen in some cases
        return ImmutableWordResponse.builder().value(result.trim()).build();
    }
}
