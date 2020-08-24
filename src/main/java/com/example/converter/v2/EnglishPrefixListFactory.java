package com.example.converter.v2;

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
                .put(27, withQuadrillions())
                .put(26, withQuadrillions())
                .put(25, withQuadrillions())
                .put(24, withTrilliards())
                .put(23, withTrilliards())
                .put(22, withTrilliards())
                .put(21, withTrillions())
                .put(20, withTrillions())
                .put(19, withTrillions())
                .put(18, withBilliards())
                .put(17, withBilliards())
                .put(16, withBilliards())
                .put(15, withBillions())
                .put(14, withBillions())
                .put(13, withBillions())
                .put(12, withMilliards())
                .put(11, withMilliards())
                .put(10, withMilliards())
                .put(9, withMillions())
                .put(8, withMillions())
                .put(7, withMillions())
                .put(6, withThousands())
                .put(5, withThousands())
                .put(4, withThousands())
                .put(3, withUnitsOnly())
                .put(2, withUnitsOnly())
                .put(1, withUnitsOnly())
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for an ordered {@link List} from 10^0 to 10^24
     */
    static Supplier<List<EnglishTranslator>> withQuadrillions() {
        return () -> ImmutableList.<EnglishTranslator>builder()
                .add(OverLongEnglishLongScaleMetric.QUADRILLION)
                .add(OverLongEnglishLongScaleMetric.TRILLIARD)
                .add(OverLongEnglishLongScaleMetric.TRILLION)
                .add(OverLongEnglishLongScaleMetric.BILLIARD)
                .add(OverLongEnglishLongScaleMetric.BILLION)
                .add(OverLongEnglishLongScaleMetric.MILLARD)
                .add(OverLongEnglishLongScaleMetric.MILLION)
                .add(OverLongEnglishLongScaleMetric.THOUSAND)
                .add(OverLongEnglishLongScaleMetric.ONE)
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for an ordered {@link List} of {@link EnglishTranslator} from 10^0 to 10^21
     */
    static Supplier<List<EnglishTranslator>> withTrilliards() {
        return () -> ImmutableList.<EnglishTranslator>builder()
                .add(OverLongEnglishLongScaleMetric.TRILLIARD)
                .add(OverLongEnglishLongScaleMetric.TRILLION)
                .add(OverLongEnglishLongScaleMetric.BILLIARD)
                .add(OverLongEnglishLongScaleMetric.BILLION)
                .add(OverLongEnglishLongScaleMetric.MILLARD)
                .add(OverLongEnglishLongScaleMetric.MILLION)
                .add(OverLongEnglishLongScaleMetric.THOUSAND)
                .add(OverLongEnglishLongScaleMetric.ONE)
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for an ordered {@link List} of {@link EnglishTranslator} from 10^0 to 10^18
     */
    static Supplier<List<EnglishTranslator>> withTrillions() {
        return () -> ImmutableList.<EnglishTranslator>builder()
                .add(OverLongEnglishLongScaleMetric.TRILLION)
                .add(OverLongEnglishLongScaleMetric.BILLIARD)
                .add(OverLongEnglishLongScaleMetric.BILLION)
                .add(OverLongEnglishLongScaleMetric.MILLARD)
                .add(OverLongEnglishLongScaleMetric.MILLION)
                .add(OverLongEnglishLongScaleMetric.THOUSAND)
                .add(OverLongEnglishLongScaleMetric.ONE)
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for an ordered {@link List} of {@link EnglishTranslator} from 10^0 to 10^15
     */
    static Supplier<List<EnglishTranslator>> withBilliards() {
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
    static Supplier<List<EnglishTranslator>> withBillions() {
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
    static Supplier<List<EnglishTranslator>> withMilliards() {
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
    static Supplier<List<EnglishTranslator>> withMillions() {
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
    static Supplier<List<EnglishTranslator>> withThousands() {
        return () -> ImmutableList.<EnglishTranslator>builder()
                .add(EnglishLongScaleMetric.THOUSAND)
                .add(EnglishLongScaleMetric.ONE)
                .build();
    }

    /**
     *
     * @return a {@link Supplier} for a 10^0 {@link EnglishTranslator}
     */
    static Supplier<List<EnglishTranslator>> withUnitsOnly() {
        return () -> Collections.singletonList(EnglishLongScaleMetric.ONE);
    }
}
