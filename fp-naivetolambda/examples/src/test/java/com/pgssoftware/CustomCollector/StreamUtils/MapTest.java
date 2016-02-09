/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.CustomCollector.StreamUtils;

import com.pgssoftware.exercises.StreamUtils.StreamUtils;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kuba
 */
public class MapTest {
    
    public MapTest() {
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
    //@Test
    public void mapExample() {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        List<Integer> values = StreamUtils.map(stream, x -> x + 1);
        assertEquals(Arrays.asList(2, 3, 4), values);
    }
    
    @Test
    public void mapExampleParallel() {
        Stream<Integer> parallelStream = Stream.of(1, 2, 3).parallel();
	List<Integer> values = StreamUtils.map(parallelStream, x -> x + 1);
        assertEquals(Arrays.asList(2, 3, 4), values);
    }
}
