/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.MyStringUtils;

import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @author kuba
 */
public class TrimmedUppercasedTest {

    @Test
    public void shouldUppercaseTwoLetterStringByLambda() {
        List<String> input = Arrays.asList("ab");
        List<String> result = MyStringUtils.trimmedUppercased(input);
        Assertions.assertThat(result).isEqualTo(asList("Ab"));
    }
    
    @Test
    public void shouldTrimStringByLambda() {
        List<String> input = Arrays.asList("     ee  ");
        List<String> result = MyStringUtils.trimmedUppercased(input);
        Assertions.assertThat(result).isEqualTo(asList("Ee"));
    }
}
