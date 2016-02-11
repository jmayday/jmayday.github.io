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
import org.junit.Test;

/**
 *
 * @author kuba
 */
public class MapToStringsTest {
    
    @Test
    public void shouldMapToStrings() {
        List<Integer> input = IntStream.range(0, 11).boxed().collect(toList());
        List<String> mapToStrings = SideEffects.mapToStringsBuggyNotSynchronized(input.stream());
        List<String> expected = input.stream().map(i -> i.toString()).collect(toList());
        assertThat(mapToStrings).isEqualTo(expected);
    }
    
    // TODO uncomment to see the problem
    // @Test
    public void shouldMapToStringsParallel() {
        List<Integer> input = IntStream.range(0, 11).boxed().collect(toList());
        List<String> actual = SideEffects.mapToStringsBuggyNotSynchronized(input.parallelStream());
        List<String> expected = input.stream().map(i -> i.toString()).collect(toList());
        assertThat(actual).isEqualTo(expected);
    }
     
    @Test
    public void shouldMapToStringsParallelAndConcurrent() {
        List<Integer> input = IntStream.range(0, 11).boxed().collect(toList());
        Set<String> actual = SideEffects.mapToStringsBuggy(input.parallelStream());
        Set<String> expected = input.stream().map(i -> i.toString()).collect(toSet());
        assertThat(actual).isEqualTo(expected);
    }
         
    @Test
    public void shouldMapToStringsGoodWayParallel() {
        List<Integer> input = IntStream.range(0, 11).boxed().collect(toList());
        Set<String> actual = SideEffects.mapToStringsRecommendedWay(input.parallelStream());
        Set<String> expected = input.stream().map(i -> i.toString()).collect(toSet());
        assertThat(actual).isEqualTo(expected);
    }
     
}
