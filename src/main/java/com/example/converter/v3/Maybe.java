package com.example.converter.v3;

/**
 * https://www.freecodecamp.org/news/optional-in-java-and-anti-patterns-using-it-7d87038362ba/
 * https://hackage.haskell.org/package/base-4.11.1.0/docs/Data-Maybe.html
 * https://hackage.haskell.org/package/base-4.11.1.0/docs/Data-Either.html#v:Either
 * https://medium.com/swlh/write-a-monad-in-java-seriously-50a9047c9839
 */
public interface Maybe<T> {

    default T getValue() {
        return null;
    }

    /**
     * @param value A nullable value
     * @param <T>   Type of the value to be hold by this result
     * @return A result holding the value, if the value is not null, else, an empty result
     */
    static <T> Maybe<T> of(T value) {
        return value == null ? empty() : success(value);
    }

    /**
     * @param value a value
     * @param <T>   the type of the value to be hold by this result
     * @return maybe a success
     */
    static <T> Maybe<T> success(T value) {


        return new Success<>(value);
    }

    /**
     * @return maybe an empty value
     */
    static <T> Maybe<T> empty() {

        return new Empty<>();
    }

    class Success<V> implements Maybe<V> {
        private final V value;

        private Success(V value) {
            this.value = value;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    class Empty<T> implements Maybe<T> {

    }
}
