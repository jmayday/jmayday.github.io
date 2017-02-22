package com.pgssoftware.news;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JupiterLazyEnabledAssertEqualsTest extends AssertEquals {

    @Test
    void shouldFind3DifferencesWithLambda() {
        short expected = 3;
        short actual = 3;
        assertEquals(expected, actual, () -> getAssertionMessage());
    }


}
