package com.example.converter.v3;

/**
 * Service for converting a {@link EnglishNumber} into a {@link Maybe} response
 */
interface TranslationService {

    /**
     *
     * @param number a {@link EnglishNumber}
     * @return an instance of {@link Maybe}
     */
    Maybe<String> translateNumber(EnglishNumber number);
}
