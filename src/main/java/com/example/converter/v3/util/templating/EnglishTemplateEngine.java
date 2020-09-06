package com.example.converter.v3.util.templating;

import com.example.converter.v3.ThreeDigits;
import org.springframework.context.MessageSource;

import javax.validation.constraints.NotNull;
import java.util.Locale;
import java.util.Optional;

/**
 * A template engine for english resources
 */
public class EnglishTemplateEngine {

    /**
     * a {@link MessageSource}
     */
    private final MessageSource messageSource;

    public EnglishTemplateEngine(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private String value(@NotNull String property, @NotNull ThreeDigits object) {
        if (object.isNotZero()) {
            String param = messageSource.getMessage(object.getValue(), null, Locale.ENGLISH);
            return messageSource.getMessage(property, new Object[]{param}, Locale.ENGLISH);
        }

        return "";
    }

    /**
     *
     * @return a {@link String} for the negative symbol
     */
    public String processNegativeSign() {
        return messageSource.getMessage("minus", null, Locale.ENGLISH);
    }

    /**
     *
     * @return a {@link String} for the Zero
     */
    public String processZero() {
        return messageSource.getMessage("0", null, Locale.ENGLISH);
    }

    /**
     *
     * @param object an {@link Optional} of a {@link ThreeDigits}
     * @return a {@link String}
     */
    public String processUnit(@NotNull ThreeDigits object) {
        if (object.isNotZero()) {
            return messageSource.getMessage(object.getValue(), null, Locale.ENGLISH);
        }
        return "";
    }

    /**
     *
     * @param object an {@link Optional} of a {@link ThreeDigits}
     * @return a {@link String}
     */
    public String processThousand(@NotNull ThreeDigits object) {
        return value("thousand", object);
    }

    /**
     *
     * @param object an {@link Optional} of a {@link ThreeDigits}
     * @return a {@link String}
     */
    public String processMillion(@NotNull ThreeDigits object) {
        return value("million", object);

    }

    /**
     *
     * @param object an {@link Optional} of a {@link ThreeDigits}
     * @return a {@link String}
     */
    public String processMilliard(@NotNull ThreeDigits object) {
        return value("milliard", object);
    }

    /**
     *
     * @param object an {@link Optional} of a {@link ThreeDigits}
     * @return a {@link String}
     */
    public String processBillion(@NotNull ThreeDigits object) {
        return value("billion", object);
    }

    /**
     *
     * @param object an {@link Optional} of a {@link ThreeDigits}
     * @return a {@link String}
     */
    public String processBilliard(@NotNull ThreeDigits object) {
        return value("billiard", object);
    }

    /**
     *
     * @param object an {@link Optional} of a {@link ThreeDigits}
     * @return a {@link String}
     */
    public String processTrillion(@NotNull ThreeDigits object) {
        return value("trillion", object);
    }

    /**
     *
     * @param object an {@link Optional} of a {@link ThreeDigits}
     * @return a {@link String}
     */
    public String processTrilliard(@NotNull ThreeDigits object) {
        return value("trilliard", object);
    }

    /**
     *
     * @param object an {@link Optional} of a {@link ThreeDigits}
     * @return a {@link String}
     */
    public String processQuintillion(@NotNull ThreeDigits object) {
        return value("quintillion", object);
    }
}
