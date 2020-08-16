package com.example.converter.exposed;

import com.example.converter.domain.NumberRequest;
import com.example.converter.domain.WordResponse;
import com.example.converter.service.ConversionService;
import com.example.converter.service.ConversionServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Webservice for converting an {@link Integer} into an English-formatted string
 */
@RestController
@RequestMapping("/api/v1")
public class IntegerToWordsConversionRestService {

    private final ConversionService service = new ConversionServiceImpl();

    @GetMapping(value = "/convert/{value}", produces = "application/json")
    public WordResponse convert(@PathVariable Integer value) {

        return service.convertNumber(new NumberRequest(value));
    }
}
