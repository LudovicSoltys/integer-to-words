package com.example.converter.service;

import com.example.converter.domain.NumberRequest;
import com.example.converter.domain.WordResponse;

/**
 * Service for converting a {@link NumberRequest} into a {@link WordResponse}
 */
public interface ConversionService {

    WordResponse convertNumber(NumberRequest number);
}
