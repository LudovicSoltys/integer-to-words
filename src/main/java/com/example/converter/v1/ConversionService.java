package com.example.converter.v1;

/**
 * Service for converting a {@link NumberRequest} into a {@link WordResponse}
 */
interface ConversionService {

    WordResponse convertNumber(NumberRequest number);
}
