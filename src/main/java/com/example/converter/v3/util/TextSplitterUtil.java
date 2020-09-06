package com.example.converter.v3.util;

import com.example.converter.v3.EnglishNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for splitting text into a bunch of {@link String}s
 */
public class TextSplitterUtil {

    private TextSplitterUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * For instance, a value such as 1.234.567.890 will be splitted in the following list of {@link String}s , in this
     * specific order (from right to left) :
     * - with a size of 1, the result is [0, 9, 8, 7, 6, 5, 4, 3, 2, 1]
     * - with a size of 3, the result is [890, 567, 234, 1]
     * - ...
     *
     * @param number a {@link EnglishNumber} to split
     * @param size the length of each piece of elements
     * @return the splitted list of {@link String}s
     */
    public static List<String> split(EnglishNumber number, int size) {

        String text = number.getAbsoluteValue();

        int count = (text.length() + size - 1) / size;
        List<String> output = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            int end = text.length() - i * size;
            int start = Math.max(end - size, 0);
            output.add(text.substring(start, end));
        }

        return output;
    }
}
