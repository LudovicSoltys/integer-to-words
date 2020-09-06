package com.example.converter.v2;

import org.immutables.value.Value;

/**
 * The result of the conversion process
 */
@Value.Immutable
interface WordResponse {

    String getValue();

    default String getVersion() {
        return "V2";
    }

    static WordResponse zeroWordResponse() {
        return ImmutableWordResponse.builder().value("zero").build();
    }
}