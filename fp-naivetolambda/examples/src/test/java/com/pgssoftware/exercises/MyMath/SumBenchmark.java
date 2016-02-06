package com.pgssoftware.exercises.MyMath;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pgssoftware.exercises.MyMath.MyMathBuggy;
import com.pgssoftware.exercises.MyMath.MyMathFixed;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import org.junit.Test;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 *
 * @author kuba
 */
public class SumBenchmark {
    
    private static final List<Long> collection = IntStream
                .range(0, 1_000_000)
                .mapToLong(i -> i)
                .boxed()
                .collect(toList());
    
    @Test
    public void shouldSum() {
        
        long div = 1000000000L;
        
        List<Long> collect2 = IntStream
                .range(0, 1_000_000)
                .mapToLong(i -> i)
                .boxed()
                .collect(toList());
                
        long buggyStart = System.nanoTime();
        long slowSumOfSquares = MyMathBuggy.sum(collect2);
        long buggyEnd = System.nanoTime();
        System.out.println("result: " + slowSumOfSquares + ", slow: " + (buggyEnd - buggyStart) / (double)div);

        long fixedStart = System.nanoTime();
        long slowSumOfSquares2 = MyMathFixed.sum(collect2);
        long fixedEnd = System.nanoTime();
        System.out.println("result: " + slowSumOfSquares2 + ", fixed: " + (fixedEnd - fixedStart) / (double)div);      
    }
    
    
    @Benchmark
    public long runMethodOnBuggyImpl() {
        return MyMathBuggy.sum(collection);
    }
    
    @Benchmark 
    public long runMethodOnFixedImpl() {
        return MyMathFixed.sum(collection);
    }
    
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SumBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.SECONDS)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
    
}
