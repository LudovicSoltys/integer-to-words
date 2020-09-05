package com.example.converter.v2.english;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Configuration factory
 */
public class EnglishPrefixListFactory {

    private EnglishPrefixListFactory() {
        throw new IllegalStateException("Utility class");
    }

    /**
     *
     * @param size the size of for which the list is created
     * @return a {@link List} of {@link EnglishLongScaleMetric}
     */
    public static Supplier<List<EnglishTranslator>> get(Integer size) {

        return map().get(size);
    }

    /**
     *
     * @return a {@link Map} that associates a number of characters to a {@link Supplier} for {@link EnglishTranslator}s
     */
    static Map<Integer, Supplier<List<EnglishTranslator>>> map() {
        return ImmutableMap
                .<Integer, Supplier<List<EnglishTranslator>>>builder()
                .put(27, quadrillionTranslator())
                .put(26, quadrillionTranslator())
                .put(25, quadrillionTranslator())
                .put(24, trilliardTranslator())
                .put(23, trilliardTranslator())
                .put(22, trilliardTranslator())
                .put(21, trillionTranslator())
                .put(20, trillionTranslator())
                .put(19, trillionTranslator())
                .put(18, billiardTranslator())
                .put(17, billiardTranslator())
                .put(16, billiardTranslator())
                .put(15, billionTranslator())
                .put(14, billionTranslator())
                .put(13, billionTranslator())
                .put(12, milliardTranslator())
                .put(11, milliardTranslator())
                .put(10, milliardTranslator())
                .put(9, millionTranslator())
                .put(8, millionTranslator())
                .put(7, millionTranslator())
                .put(6, thousandTranslator())
                .put(5, thousandTranslator())
                .put(4, thousandTranslator())
                .put(3, unitTranslator())
                .put(2, unitTranslator())
                .put(1, unitTranslator())
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for an ordered {@link List} from 10^0 to 10^24
     */
    static Supplier<List<EnglishTranslator>> quadrillionTranslator() {
        return () -> ImmutableList.<EnglishTranslator>builder()
                .add(BigEnglishLongScaleMetric.QUADRILLION)
                .add(BigEnglishLongScaleMetric.TRILLIARD)
                .add(BigEnglishLongScaleMetric.TRILLION)
                .add(BigEnglishLongScaleMetric.BILLIARD)
                .add(BigEnglishLongScaleMetric.BILLION)
                .add(BigEnglishLongScaleMetric.MILLARD)
                .add(BigEnglishLongScaleMetric.MILLION)
                .add(BigEnglishLongScaleMetric.THOUSAND)
                .add(BigEnglishLongScaleMetric.ONE)
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for an ordered {@link List} of {@link EnglishTranslator} from 10^0 to 10^21
     */
    static Supplier<List<EnglishTranslator>> trilliardTranslator() {
        return () -> ImmutableList.<EnglishTranslator>builder()
                .add(BigEnglishLongScaleMetric.TRILLIARD)
                .add(BigEnglishLongScaleMetric.TRILLION)
                .add(BigEnglishLongScaleMetric.BILLIARD)
                .add(BigEnglishLongScaleMetric.BILLION)
                .add(BigEnglishLongScaleMetric.MILLARD)
                .add(BigEnglishLongScaleMetric.MILLION)
                .add(BigEnglishLongScaleMetric.THOUSAND)
                .add(BigEnglishLongScaleMetric.ONE)
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for an ordered {@link List} of {@link EnglishTranslator} from 10^0 to 10^18
     */
    static Supplier<List<EnglishTranslator>> trillionTranslator() {
        return () -> ImmutableList.<EnglishTranslator>builder()
                .add(BigEnglishLongScaleMetric.TRILLION)
                .add(BigEnglishLongScaleMetric.BILLIARD)
                .add(BigEnglishLongScaleMetric.BILLION)
                .add(BigEnglishLongScaleMetric.MILLARD)
                .add(BigEnglishLongScaleMetric.MILLION)
                .add(BigEnglishLongScaleMetric.THOUSAND)
                .add(BigEnglishLongScaleMetric.ONE)
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for an ordered {@link List} of {@link EnglishTranslator} from 10^0 to 10^15
     */
    static Supplier<List<EnglishTranslator>> billiardTranslator() {
        return () -> ImmutableList.<EnglishTranslator>builder()
                .add(EnglishLongScaleMetric.BILLIARD)
                .add(EnglishLongScaleMetric.BILLION)
                .add(EnglishLongScaleMetric.MILLARD)
                .add(EnglishLongScaleMetric.MILLION)
                .add(EnglishLongScaleMetric.THOUSAND)
                .add(EnglishLongScaleMetric.ONE)
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for an ordered {@link List} of {@link EnglishTranslator} from 10^0 to 10^12
     */
    static Supplier<List<EnglishTranslator>> billionTranslator() {
        return () -> ImmutableList.<EnglishTranslator>builder()
                .add(EnglishLongScaleMetric.BILLION)
                .add(EnglishLongScaleMetric.MILLARD)
                .add(EnglishLongScaleMetric.MILLION)
                .add(EnglishLongScaleMetric.THOUSAND)
                .add(EnglishLongScaleMetric.ONE)
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for an ordered {@link List} of {@link EnglishTranslator} from 10^0 to 10^9
     */
    static Supplier<List<EnglishTranslator>> milliardTranslator() {
        return () -> ImmutableList.<EnglishTranslator>builder()
                .add(EnglishLongScaleMetric.MILLARD)
                .add(EnglishLongScaleMetric.MILLION)
                .add(EnglishLongScaleMetric.THOUSAND)
                .add(EnglishLongScaleMetric.ONE)
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for an ordered {@link List} of {@link EnglishTranslator} from 10^0 to 10^6
     */
    static Supplier<List<EnglishTranslator>> millionTranslator() {
        return () -> ImmutableList.<EnglishTranslator>builder()
                .add(EnglishLongScaleMetric.MILLION)
                .add(EnglishLongScaleMetric.THOUSAND)
                .add(EnglishLongScaleMetric.ONE)
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for an ordered {@link List} of {@link EnglishTranslator} from 10^0 to 10^3
     */
    static Supplier<List<EnglishTranslator>> thousandTranslator() {
        return () -> ImmutableList.<EnglishTranslator>builder()
                .add(EnglishLongScaleMetric.THOUSAND)
                .add(EnglishLongScaleMetric.ONE)
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for a 10^0 {@link EnglishTranslator}
     */
    static Supplier<List<EnglishTranslator>> unitTranslator() {
        return () -> Collections.singletonList(EnglishLongScaleMetric.ONE);
    }
}
