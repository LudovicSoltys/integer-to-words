package com.example.converter.v3;

import com.example.converter.v3.converter.ThreeDigitsCollectionConverter;

import java.util.List;
import java.util.function.Function;

/**
 * a converter for non-zero numbers
 */
public class NonZeroAggregateConverter implements Function<ThreeDigitsCollection, String> {

    private final List<ThreeDigitsCollectionConverter> converters;

    public NonZeroAggregateConverter(List<ThreeDigitsCollectionConverter> converters) {
        this.converters = converters;
    }

    @Override
    public String apply(ThreeDigitsCollection collection) {

        StringBuilder output = new StringBuilder();
        converters.stream()
                // we stop the loop as soon as one converter is not valid.
                // Ex : if there is no million-type, there is no need to check for milliard-, billion-, and so on
                .takeWhile(bufferDecorator -> bufferDecorator.test(collection))
                .forEach(bufferDecorator -> output.insert(0, " " + bufferDecorator.apply(collection)));

        return output.toString().trim();
    }
}
