package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;

import java.util.List;

/**
 * a converter for non-zero numbers
 */
public class NonZeroEnglishNumberConverter implements ThreeDigitsCollectionConverter {

    private final List<ThreeDigitsCollectionConverter> converters;

    private final NegativeSignConverter negativeSignConverter;

    public NonZeroEnglishNumberConverter(List<ThreeDigitsCollectionConverter> converters, NegativeSignConverter negativeSignConverter) {
        this.converters = converters;
        this.negativeSignConverter = negativeSignConverter;
    }

    @Override
    public boolean check(ThreeDigitsCollection collection) {
        return collection.isNotZero();
    }

    @Override
    public String convert(ThreeDigitsCollection collection) {

        StringBuilder output = new StringBuilder();
        converters.stream()
                // we stop the loop as soon as one converter is not valid.
                // Ex : if there is no million-type, there is no need to check for milliard-, billion-, and so on
                .takeWhile(bufferDecorator -> bufferDecorator.check(collection))
                .forEach(bufferDecorator -> output.insert(0, " " + bufferDecorator.convert(collection)));

        if (negativeSignConverter.check(collection)) {
            output.insert(0,negativeSignConverter.convert(collection));
        }

        return output.toString().trim();
    }
}