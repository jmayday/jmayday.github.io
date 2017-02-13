package com.pgssoftware;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class E05ExceptionsTestingTest {


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException() {

        Generator generator = new Generator();
        String actual = generator.generate(null,0);
    }

    @Test
    public void shouldThrowExceptionWithMessage() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("length must not be lower than 3");

        Generator generator = new Generator();
        String actual = generator.generate("AAAE",0);
    }
}
