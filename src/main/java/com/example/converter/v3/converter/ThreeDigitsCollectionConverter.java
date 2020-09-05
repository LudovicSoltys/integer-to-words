package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;

public interface ThreeDigitsCollectionConverter {

    boolean check(ThreeDigitsCollection collection);

    String convert(ThreeDigitsCollection collection);
}
