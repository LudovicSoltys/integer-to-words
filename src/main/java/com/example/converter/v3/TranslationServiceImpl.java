package com.example.converter.v3;

import com.example.converter.v3.converter.ThreeDigitsCollectionConverter;

import java.util.function.Supplier;

/**
 * default implementation of {@link TranslationService}
 */
public class TranslationServiceImpl implements TranslationService {

    private final Supplier<ThreeDigitsCollectionConverter> nonZeroConverterSupplier;

    private final Supplier<ThreeDigitsCollectionConverter> zeroConverterSupplier;

    public TranslationServiceImpl(Supplier<ThreeDigitsCollectionConverter> nonZeroConverterSupplier,
                                  Supplier<ThreeDigitsCollectionConverter> zeroConverterSupplier) {
        this.nonZeroConverterSupplier = nonZeroConverterSupplier;
        this.zeroConverterSupplier = zeroConverterSupplier;
    }

    @Override
    public WordResponse translateNumber(EnglishNumber number) {

        ThreeDigitsCollection collection = ThreeDigitsCollection.instance(number);
        String output = get(collection).apply(collection);

        return ImmutableWordResponse.builder()
                .value(output)
                .build();
    }

    private ThreeDigitsCollectionConverter get(ThreeDigitsCollection collection) {

        return collection.isNotZero() ? this.nonZeroConverterSupplier.get() : this.zeroConverterSupplier.get();
    }
}
