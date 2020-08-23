package com.example.converter.v2;

/**
 * Service for converting a {@link NumberRequest} into a {@link WordResponse}
 */
public interface TranslateStrategy {

    /**
     *
     * @param number a {@link NumberRequest}
     * @return an instance of {@link WordResponse}
     */
    WordResponse convertNumber(NumberRequest number);
}
