package com.example.converter.v2;

/**
 * Service for converting a {@link String} into a {@link WordResponse}
 */
interface ConversionService {

    WordResponse convertNumber(String number);
}
