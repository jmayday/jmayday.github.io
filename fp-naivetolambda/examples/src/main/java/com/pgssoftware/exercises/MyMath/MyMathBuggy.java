/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.MyMath;

import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author kuba
 */
public class MyMathBuggy {

    public static long multiplyThrough(List<Long> linkedListOfNumbers, long multiplier) {
        return multiplyThrough(linkedListOfNumbers
                .stream(), multiplier);
                
    }
    
    public static long multiplyThrough(Stream<Long> stream, long multiplier) {
        return stream
                .reduce(multiplier, (acc, x) -> x * acc);
                
    }

    public static Long sum(List<Long> linkedListOfNumbers) {
        return linkedListOfNumbers
                .parallelStream()
                .map(x -> x )
                .reduce(0L, (acc, x) -> acc + x);
    }

}
