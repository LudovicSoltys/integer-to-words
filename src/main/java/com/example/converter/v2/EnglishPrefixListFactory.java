package com.example.converter.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * An utility factory
 */
public class EnglishPrefixListFactory {

    /**
     *
     * @param size the size of for which the list is created
     * @return a {@link List} of {@link EnglishLongScaleMetric}
     */
    public static List<EnglishLongScaleMetric> get(Integer size) {

        List<EnglishLongScaleMetric> list = new ArrayList<>();

        for (EnglishLongScaleMetric entry : EnglishLongScaleMetric.values()) {
            if (entry.getMinDigitsCount() < size) {
                list.add(entry);
            }
        }

        return list;
    }
}
