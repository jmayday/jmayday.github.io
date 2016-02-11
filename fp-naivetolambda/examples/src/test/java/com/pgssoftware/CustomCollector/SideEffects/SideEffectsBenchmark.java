/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.CustomCollector.SideEffects;

import com.pgssoftware.exercises.CustomCollector.SideEffects.SideEffects;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
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
public class SideEffectsBenchmark {
    
    private static List<Integer> input = IntStream.range(0, 100_000).boxed().collect(toList());
    
    @Benchmark
    public Set<String> runMethodMapToStringsBuggy() {
        return SideEffects.mapToStringsBuggy(input.parallelStream());
    }
         
    @Benchmark
    public Set<String> runMethodMapToStringsRecommendedWay() {
        return SideEffects.mapToStringsRecommendedWay(input.parallelStream());
    }
    
    @Benchmark
    public ConcurrentMap<String, String> runMethodMapToStringsConcurrent() {
        return SideEffects.mapToStringsConcurrent(input.parallelStream());
    }
    
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SideEffectsBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.SECONDS)
                .measurementIterations(5)
                .forks(1)
                .threads(2)
                .build();

        new Runner(opt).run();
    }
}
