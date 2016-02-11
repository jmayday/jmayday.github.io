/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.CustomCollector.SideEffects;

import com.pgssoftware.exercises.CustomCollector.SideEffects.SideEffects;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import java.util.stream.IntStream;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kuba
 */
public class MapToStringsTest {
    
    public MapToStringsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void shouldMapToStrings() {
        List<Integer> input = IntStream.range(0, 11).boxed().collect(toList());
        List<String> mapToStrings = SideEffects.mapToStrings(input.stream());
        List<String> expected = input.stream().map(i -> i.toString()).collect(toList());
        assertThat(mapToStrings).isEqualTo(expected);
     }
     
    @Test
    public void shouldMapToStringsParallel() {
        List<Integer> input = IntStream.range(0, 11).boxed().collect(toList());
        Set<String> mapToStrings = SideEffects.mapToStringsBuggy(input.parallelStream());
        Set<String> expected = input.stream().map(i -> i.toString()).collect(toSet());
        assertThat(mapToStrings).isEqualTo(expected);
    }
         
    @Test
    public void shouldMapToStringsGoodWayParallel() {
        List<Integer> input = IntStream.range(0, 11).boxed().collect(toList());
        Set<String> mapToStrings = SideEffects.mapToStringsRecommendedWay(input.parallelStream());
        Set<String> expected = input.stream().map(i -> i.toString()).collect(toSet());
        assertThat(mapToStrings).isEqualTo(expected);
    }
     
}
