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
     * @return a {@link List} of {@link EnglishLongScaleMetricPrefix}
     */
    public static List<EnglishLongScaleMetricPrefix> get(Integer size) {

        List<EnglishLongScaleMetricPrefix> list = new ArrayList<>();

        for (EnglishLongScaleMetricPrefix entry : EnglishLongScaleMetricPrefix.values()) {
            if (entry.getMinDigitsCount() < size) {
                list.add(entry);
            }
        }

        return list;
    }
}
