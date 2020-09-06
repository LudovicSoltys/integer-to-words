package com.example.converter.v3;

import org.immutables.value.Value;

/**
 * The result of the conversion process
 */
@Value.Immutable
interface WordResponse {

    String getValue();

    default String getVersion() {
        return "V1";
    }
}