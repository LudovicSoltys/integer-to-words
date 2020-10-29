package com.example.converter.v3;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public interface EnglishNumber {

    static EnglishNumber of(String value) {

        boolean isInteger = value.matches("-?\\d+");
        if (!isInteger) {
            throw new IllegalArgumentException("Unexpected value. Only integers allowed");
        }

        boolean isLowerThanZero = value.startsWith("-");
        boolean isZero = Pattern.compile("^-?0+$").matcher(value).matches();

        if (isZero) {
            return new Zero();
        } else if (isLowerThanZero) {
            return new NegativeNonZero(value);
        }
        return new PositiveNonZero(value);
    }

    boolean isZero();

    boolean isPositive();

    boolean isNegative();

    String getAbsoluteValue();

    <R> Optional<R> map(Function<EnglishNumber, R> nonZeroFunction, UnaryOperator<R> minusSignFunction, UnaryOperator<R> plusSignFunction);

    default <R> Optional<R> map(Function<EnglishNumber, R> nonZeroFunction, UnaryOperator<R> minusSignFunction) {
        return map(nonZeroFunction, minusSignFunction, s -> s);
    }

    class Zero implements EnglishNumber {

        @Override
        public boolean isZero() {
            return true;
        }

        @Override
        public boolean isPositive() {
            return false;
        }

        @Override
        public boolean isNegative() {
            return false;
        }

        @Override
        public String getAbsoluteValue() {
            return "0";
        }

        @Override
        public <R> Optional<R> map(Function<EnglishNumber, R> nonZeroFunction, UnaryOperator<R> minusSignFunction, UnaryOperator<R> plusSignFunction) {
            return Optional.empty();
        }
    }

    class PositiveNonZero implements EnglishNumber {

        private final String absoluteValue;

        public PositiveNonZero(String value) {
            this.absoluteValue = value;
        }

        @Override
        public boolean isZero() {
            return false;
        }

        @Override
        public boolean isPositive() {
            return true;
        }

        @Override
        public boolean isNegative() {
            return false;
        }

        @Override
        public String getAbsoluteValue() {
            return absoluteValue;
        }

        @Override
        public <R> Optional<R> map(Function<EnglishNumber, R> nonZeroFunction, UnaryOperator<R> minusSignFunction, UnaryOperator<R> plusSignFunction) {
            return Optional.of(nonZeroFunction.andThen(plusSignFunction).apply(this));
        }
    }

    class NegativeNonZero implements EnglishNumber {

        private final String absoluteValue;

        public NegativeNonZero(String value) {
            this.absoluteValue = value.substring(1);
        }

        @Override
        public boolean isZero() {
            return false;
        }

        @Override
        public boolean isPositive() {
            return false;
        }

        @Override
        public boolean isNegative() {
            return true;
        }

        @Override
        public String getAbsoluteValue() {
            return absoluteValue;
        }

        @Override
        public <R> Optional<R> map(Function<EnglishNumber, R> nonZeroFunction, UnaryOperator<R> minusSignFunction, UnaryOperator<R> plusSignFunction) {
            return Optional.of(nonZeroFunction.andThen(minusSignFunction).apply(this));
        }
    }
}