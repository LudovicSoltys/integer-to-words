package com.example.converter.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Webservice for converting an {@link Integer} into an English-formatted string
 */
@RestController
@RequestMapping("/api/v2")
public class ExtraLongNumberRestService {

    private final ExtraLongConversionService extraLongConversionService;

    public ExtraLongNumberRestService(ExtraLongConversionService extraLongConversionService) {
        this.extraLongConversionService = extraLongConversionService;
    }

    @GetMapping(value = "/convert/{value}", produces = "application/json")
    public WordResponse convert(@PathVariable String value) {

        return extraLongConversionService.convertNumber(value);
    }
}
