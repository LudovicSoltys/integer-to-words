package com.example.converter.v3;

import com.example.converter.v3.converter.*;
import com.example.converter.v3.util.templating.EnglishTemplateEngine;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.function.Supplier;

@EnableWebMvc
public class AppV3WebConfig {

    @Bean
    public TranslationController translationController(@Autowired TranslationService translationService) {

        return new TranslationController(translationService);
    }

    @Bean
    public MessageSource messageSource() {

        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("messages/numbers");
        source.setUseCodeAsDefaultMessage(true);

        return source;
    }

    @Bean
    public TranslationService translationService(@Autowired MessageSource messageSource) {

        EnglishTemplateEngine templateEngine = new EnglishTemplateEngine(messageSource);
        return new TranslationServiceImpl(nonZeroConverterSupplier(templateEngine), zeroConverterSupplier(templateEngine));
    }

    /**
     *
     * @param templateEngine a {@link EnglishTemplateEngine}
     * @return an ordered bunch of {@link ThreeDigitsCollectionConverter}s : units (10^0) < thousands (10^3) < ...
     */
    private List<ThreeDigitsCollectionConverter> converters(EnglishTemplateEngine templateEngine) {
        return ImmutableList.<ThreeDigitsCollectionConverter>builder()
                .add(new UnitConverter(templateEngine)) // 10^0
                .add(new ThousandConverter(templateEngine)) // 10^3
                .add(new MillionConverter(templateEngine)) // 10^6
                .add(new MilliardConverter(templateEngine)) // 10^9
                .add(new BillionConverter(templateEngine)) // 10^12
                .add(new BilliardConverter(templateEngine)) // 10^15
                .add(new TrillionConverter(templateEngine)) // 10^18
                .add(new TrilliardConverter(templateEngine)) // 10^21
                .add(new QuintillionConverter(templateEngine)) // 10^24
                .build();
    }

    private Supplier<ThreeDigitsCollectionConverter> nonZeroConverterSupplier(EnglishTemplateEngine templateEngine) {
      return () -> new NonZeroEnglishNumberConverter(converters(templateEngine), new NegativeSignConverter(templateEngine));
    }

    private Supplier<ThreeDigitsCollectionConverter> zeroConverterSupplier(EnglishTemplateEngine templateEngine) {

        return () -> new ZeroEnglishNumberConverter(templateEngine);
    }
}
