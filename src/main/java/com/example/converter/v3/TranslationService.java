package com.example.converter.v3;

/**
 * Service for converting a {@link EnglishNumber} into a {@link WordResponse}
 */
interface TranslationService {

    /**
     *
     * @param number a {@link EnglishNumber}
     * @return an instance of {@link WordResponse}
     */
    WordResponse translateNumber(EnglishNumber number);
}
