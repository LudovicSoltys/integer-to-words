package com.example.converter.v3;

import com.example.converter.v3.util.TextSplitterUtil;

import java.util.List;
import java.util.Optional;

/**
 * behaviour of collections of {@link ThreeDigits}
 */
public interface ThreeDigitsCollection {

    Optional<ThreeDigits> quintillions();

    Optional<ThreeDigits> trilliards();

    Optional<ThreeDigits> trillions();

    Optional<ThreeDigits> billiards();

    Optional<ThreeDigits> billions();

    Optional<ThreeDigits> milliards();

    Optional<ThreeDigits> millions();

    Optional<ThreeDigits> thousands();

    Optional<ThreeDigits> units();

    boolean isNegative();

    boolean isNotZero();

    default boolean isZero() {
        return !isNotZero();
    }

    /**
     *
     * @param number a {@link EnglishNumber}
     * @return an instance of {@link ThreeDigitsCollection}
     */
    static ThreeDigitsCollection instance(EnglishNumber number) {

        List<String> list = TextSplitterUtil.split(number, 3);

        return new ThreeDigitsCollection.EnglishThreeDigitsCollection(list, !number.isZero(), number.isLowerThanZero());
    }

    /**
     * default implementation of {@link ThreeDigitsCollection}
     */
    class EnglishThreeDigitsCollection implements ThreeDigitsCollection {

        private final List<String> numbers;

        private final int size;

        private final boolean isNotZero;

        private final boolean isNegative;

        public EnglishThreeDigitsCollection(List<String> texts, boolean isNotZero, boolean isNegative) {
            this.numbers = texts;
            this.size = texts.size();
            this.isNegative = isNegative;
            this.isNotZero = isNotZero;
        }

        @Override
        public boolean isNotZero() {
            return isNotZero;
        }

        @Override
        public boolean isNegative() {
            return isNegative;
        }

        @Override
        public Optional<ThreeDigits> quintillions() {
            return value(8);
        }

        @Override
        public Optional<ThreeDigits> trilliards() {
            return value(7);
        }

        @Override
        public Optional<ThreeDigits> trillions() {
            return value(6);
        }

        @Override
        public Optional<ThreeDigits> billiards() {
            return value(5);
        }

        @Override
        public Optional<ThreeDigits> billions() {
            return value(4);
        }

        @Override
        public Optional<ThreeDigits> milliards() {
            return value(3);
        }

        @Override
        public Optional<ThreeDigits> millions() {
            return value(2);
        }

        @Override
        public Optional<ThreeDigits> thousands() {
            return value(1);
        }

        @Override
        public Optional<ThreeDigits> units() {
            return value(0);
        }

        /**
         *
         * @param index a position in the list
         * @return an {@link Optional} for {@link ThreeDigits}
         */
        private Optional<ThreeDigits> value(int index) {
            return index < size ? Optional.of(ThreeDigits.threeDigits(numbers.get(index))) : Optional.empty();
        }
    }
}
