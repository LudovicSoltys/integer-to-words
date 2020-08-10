package com.example.converter.domain;

import org.immutables.value.Value;

/**
 * The result of the conversion process
 */
@Value.Immutable
public interface WordResponse {

    String getValue();

    static WordResponse zeroWordResponse() {
        return ImmutableWordResponse.builder().value("zero").build();
    }
}