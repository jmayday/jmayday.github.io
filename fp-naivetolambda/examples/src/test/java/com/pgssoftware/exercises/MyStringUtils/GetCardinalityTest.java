package com.pgssoftware.exercises.MyStringUtils;


import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kuba
 */
public class GetCardinalityTest {
    
    
    @Test
    public void shouldCountEntries() {
        Collection<String> names = Arrays.asList("John", "Paul", "George", "John", "Paul", "John");

        Map<String, Long> cardinality = MyStringUtils.getCardinality(names);
        
        Assertions.assertThat(cardinality).containsEntry("John", 3L);
        Assertions.assertThat(cardinality).containsEntry("Paul", 2L);
        Assertions.assertThat(cardinality).containsEntry("George", 1L);
    }
    
}
