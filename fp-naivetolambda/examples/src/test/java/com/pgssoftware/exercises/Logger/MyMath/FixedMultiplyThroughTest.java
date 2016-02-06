package com.pgssoftware.exercises.Logger.MyMath;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pgssoftware.exercises.MyMath.MyMathBuggy;
import com.pgssoftware.exercises.MyMath.MyMathFixed;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import org.junit.Test;
import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 *
 * @author kuba
 */
public class FixedMultiplyThroughTest {
    
    @Test
    public void shouldMultiplyThrough() {
        List<Long> linkedListOfNumbers = Stream
                .of(1,2,3,4,5)
                .map(Long::new)
                .collect(toList());
        
        long multiplyThrough = MyMathFixed.multiplyThrough(linkedListOfNumbers, 5L);
        assertThat(multiplyThrough).isEqualTo(600);
    }
    
    @Test
    public void shouldMultiplyThroughStream() {
        List<Long> linkedListOfNumbers = Stream
                .of(1,2,3,4,5)
                .map(Long::new)
                .collect(toList());
        
        long multiplyThrough = MyMathFixed.multiplyThrough(linkedListOfNumbers.stream(), 5L);
        assertThat(multiplyThrough).isEqualTo(600);
    }
    
    @Test
    public void shouldMultiplyThroughParallelStream() {
        List<Long> linkedListOfNumbers = Stream
                .of(1,2,3,4,5)
                .map(Long::new)
                .collect(toList());
        
        long multiplyThrough = MyMathFixed.multiplyThrough(linkedListOfNumbers.parallelStream(), 5L);
        assertThat(multiplyThrough).isEqualTo(600);
    }
    
    
}
