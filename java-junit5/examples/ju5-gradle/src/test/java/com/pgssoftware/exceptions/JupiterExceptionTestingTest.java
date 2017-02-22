package com.pgssoftware.exceptions;


import com.pgssoftware.Generator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JupiterExceptionTestingTest {

    @Test
    public void shouldThrowExceptionJupiter() {

        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Generator generator = new Generator();
                    String actual = generator.generate(null, 0);
                });
        Assertions.assertEquals("parameter must not be null", throwable.getMessage());

    }

}
