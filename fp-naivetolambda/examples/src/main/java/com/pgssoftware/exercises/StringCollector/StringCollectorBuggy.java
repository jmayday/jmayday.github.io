/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.StringCollector;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier; 
import java.util.stream.Collector;

/**
 *
 * @author kuba
 */
public class StringCollectorBuggy implements Collector<String, StringCombinerBuggy, String> {

    private final String delim;
    private final String prefix;
    private final String suffix;

    public StringCollectorBuggy(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }
   
    @Override
    public Supplier<StringCombinerBuggy> supplier() {
        return () -> new StringCombinerBuggy(delim, prefix, suffix);
    }

    @Override
    public BiConsumer<StringCombinerBuggy, String> accumulator() {
        return StringCombinerBuggy::add;
    }

    @Override
    public BinaryOperator<StringCombinerBuggy> combiner() {
        return StringCombinerBuggy::merge;
    }

    @Override
    public Function<StringCombinerBuggy, String> finisher() {
        return StringCombinerBuggy::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Sets.newHashSet();
    }

}
