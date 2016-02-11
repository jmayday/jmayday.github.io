/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.CustomCollector.StreamUtils;

import com.pgssoftware.exercises.StreamUtils.StreamUtilsBuggy;
import com.pgssoftware.exercises.StreamUtils.StreamUtilsFixed;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author kuba
 */
public class MapTest {
    
    @Test
    public void mapExample() {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        List<Integer> values = StreamUtilsBuggy.map(stream, x -> x + 1);
        assertEquals(Arrays.asList(2, 3, 4), values);
    }
    
    // TODO uncomment to see the problem
    // @Test
    public void mapExampleParallel() {
        Stream<Integer> parallelStream = Stream.of(1, 2, 3).parallel();
	List<Integer> values = StreamUtilsBuggy.map(parallelStream, x -> x + 1);
        assertEquals(Arrays.asList(2, 3, 4), values);
    }
    
    @Test
    public void mapExampleParallelFixed() {
        Stream<Integer> parallelStream = Stream.of(1, 2, 3).parallel();
	List<Integer> values = StreamUtilsFixed.map(parallelStream, x -> x + 1);
        assertEquals(Arrays.asList(2, 3, 4), values);
    }
}
