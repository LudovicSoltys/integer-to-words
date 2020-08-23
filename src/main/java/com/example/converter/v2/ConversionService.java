package com.example.converter.v2;

/**
 * Service for converting a {@link NumberRequest} into a {@link WordResponse}
 */
interface ConversionService {

    WordResponse convertNumber(NumberRequest number);
}
