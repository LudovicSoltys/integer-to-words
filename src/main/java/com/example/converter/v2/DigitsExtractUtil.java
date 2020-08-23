package com.example.converter.v2;

import java.text.DecimalFormat;
import java.text.Format;

/**
 * a toolbox for extracting {@link ThreeDigits} from {@link Integer}s
 */
public class DigitsExtractUtil {

    public static final String EIGHTEEN_ZEROS_PATTERN = "000000000000000000";

    public static final Format DECIMAL_FORMAT = new DecimalFormat(EIGHTEEN_ZEROS_PATTERN);
}
