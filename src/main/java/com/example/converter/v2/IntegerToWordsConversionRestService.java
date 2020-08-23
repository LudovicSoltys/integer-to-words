package com.example.converter.v2;

import com.example.converter.v2.ConversionService;
import com.example.converter.v2.ConversionServiceImpl;
import com.example.converter.v2.NumberRequest;
import com.example.converter.v2.WordResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Webservice for converting an {@link Integer} into an English-formatted string
 */
@RestController
@RequestMapping("/api/v2")
public class IntegerToWordsConversionRestService {

    private final ConversionService service = new ConversionServiceImpl();

    @GetMapping(value = "/convert/{value}", produces = "application/json")
    public WordResponse convert(@PathVariable String value) {

        return service.convertNumber(new NumberRequest(value));
    }
}
