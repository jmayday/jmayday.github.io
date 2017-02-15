package com.pgssoftware;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class E051ExceptionsTestingTest {



    @Test
    public void shouldThrowException() {

        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Generator generator = new Generator();
                    String actual = generator.generate(null, 0);
                });
        Assertions.assertEquals("parameter must not be null", throwable.getMessage());

    }

    @Test
    public void shouldThrowExceptionWithMessage() {

        Generator generator = new Generator();
        String actual = generator.generate("AAAE",0);
    }
}
