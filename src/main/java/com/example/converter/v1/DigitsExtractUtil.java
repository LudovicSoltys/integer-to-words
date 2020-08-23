package com.example.converter.v1;

import java.text.DecimalFormat;

/**
 * a toolbox for extracting {@link ThreeDigits} from {@link Integer}s
 */
class DigitsExtractUtil {

    /**
     *
     * @param input an Integer
     * @return a {@link ThreeDigits} of the millions of the input (XXX------)
     */
    static ThreeDigits millions(Integer input) {

        String number = new DecimalFormat("000000000").format(input);
        return new ThreeDigits(Integer.parseInt(number.substring(0, 3)));
    }

    /**
     *
     * @param input an Integer
     * @return a {@link ThreeDigits} of the thousands of the input (---XXX---)
     */
    static ThreeDigits thousands(Integer input) {

        String number = new DecimalFormat("000000000").format(input);
        return new ThreeDigits(Integer.parseInt(number.substring(3, 6)));
    }

    /**
     *
     * @param input an Integer
     * @return a {@link ThreeDigits} of the units of the input (------XXX)
     */
    static ThreeDigits units(Integer input) {

        String number = new DecimalFormat("000000000").format(input);
        return new ThreeDigits(Integer.parseInt(number.substring(6, 9)));
    }
}
