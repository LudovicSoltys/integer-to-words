package com.example.converter.v1;

public class TestUtil {

    static int randomInt(int lower, int upper) {
        return (int) (Math.random() * (upper - lower)) + lower;
    }
}
