package com.example.converter.v1;

import org.immutables.value.Value;

/**
 * The result of the conversion process
 */
@Value.Immutable
interface WordResponse {

    String getValue();

    static WordResponse zeroWordResponse() {
        return ImmutableWordResponse.builder().value("zero").build();
    }
}