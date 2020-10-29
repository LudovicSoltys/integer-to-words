package com.example.converter.v3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Webservice for converting an {@link Integer} into an English-formatted string
 */
@RestController
@RequestMapping("/api/v3")
public class TranslationController {

    private final TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping(value = "/convert/{value}", produces = "application/json")
    public Maybe<String> convert(@PathVariable String value) {

        return translationService.translateNumber(EnglishNumber.of(value));
    }
}
