/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.MyStringUtils;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @author kuba
 */
public class TrimmedUppercasedReworkedTest {

    @Test
    public void shouldUppercaseTwoLetterStringByLambda() {
        String input = "ab";
        String actual = MyStringUtilsReworked.trimAndUppercase(input);
        String expected = "Ab";
        Assertions.assertThat(actual).isEqualTo(expected);
    }
    
    @Test
    public void shouldTrimStringByLambda() {
        String input = "     ee  ";
        String actual = MyStringUtilsReworked.trimAndUppercase(input);
        String expected = "Ee";
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
