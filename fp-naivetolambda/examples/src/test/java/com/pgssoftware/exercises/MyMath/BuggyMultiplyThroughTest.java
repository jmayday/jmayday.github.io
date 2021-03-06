package com.pgssoftware.exercises.MyMath;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import static org.assertj.core.api.StrictAssertions.assertThat;
import org.junit.Test;

/**
 *
 * @author kuba
 */
public class BuggyMultiplyThroughTest {
    
    @Test
    public void shouldMultiplyThrough() {
        List<Long> linkedListOfNumbers = Stream
                .of(1,1,1,1,1)
                .map(Long::new)
                .collect(toList());
        
        long multiplyThrough = MyMathBuggy.multiplyThrough(linkedListOfNumbers, 5L);
        assertThat(multiplyThrough).isEqualTo(5);
    }
    
    @Test
    public void shouldMultiplyThroughStream() {
        List<Long> linkedListOfNumbers = Stream
                .of(1,1,1,1,1)
                .map(Long::new)
                .collect(toList());
        
        long multiplyThrough = MyMathBuggy.multiplyThrough(linkedListOfNumbers.stream(), 5L);
        assertThat(multiplyThrough).isEqualTo(5);
    }
    
    // TODO uncomment to see the problem
    // @Test
    public void shouldMultiplyThroughParallelStream() {
        List<Long> linkedListOfNumbers = Stream
                .of(1,1,1,1,1)
                .map(Long::new)
                .collect(toList());
        
        long multiplyThrough = MyMathBuggy.multiplyThrough(linkedListOfNumbers.parallelStream(), 5L);
        assertThat(multiplyThrough).isEqualTo(5);
    }
    
    
    
}
