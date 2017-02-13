package com.pgssoftware;

public class Generator {

    private static final int MIN_LENGTH = 3;

    public String generate(String parameter, int length) {
        if (parameter == null) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        if (length < MIN_LENGTH) {
            throw new IllegalArgumentException("length must not be lower than 3");
        }
        return "xyz";
    }
}
