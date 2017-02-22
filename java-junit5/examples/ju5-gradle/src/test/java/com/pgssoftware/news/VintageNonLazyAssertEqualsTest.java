package com.pgssoftware.news;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VintageNonLazyAssertEqualsTest extends AssertEquals {

    @Test
    void shouldFind3Differences() {
        short expected = 3;
        short actual = 3;
        String assertionMessage = getAssertionMessage();
        assertEquals(expected, actual, assertionMessage);
    }

}
