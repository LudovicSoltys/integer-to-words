package com.example.converter.v2.english;

import java.text.DecimalFormat;
import java.text.Format;

/**
 * a toolbox for extracting {@link ThreeDigits} from {@link Integer}s
 */
public class TranslationUtil {

    public static final Format DECIMAL_FORMAT = new DecimalFormat("000000000000000000");

    private TranslationUtil() {
        throw new IllegalStateException("Utility class");
    }
}
