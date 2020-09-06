package com.example.converter.v3.converter;

import com.example.converter.v3.ThreeDigitsCollection;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Définition d'une stratégie de conversion
 */
public interface ThreeDigitsCollectionConverter extends Predicate<ThreeDigitsCollection>,
        Function<ThreeDigitsCollection, String> {

    /**
     *
     * @param collection
     * @return true si la conversion s'applique
     */
    boolean test(ThreeDigitsCollection collection);

    /**
     *
     * @param collection
     * @return une chaine de caractères
     */
    String apply(ThreeDigitsCollection collection);
}
