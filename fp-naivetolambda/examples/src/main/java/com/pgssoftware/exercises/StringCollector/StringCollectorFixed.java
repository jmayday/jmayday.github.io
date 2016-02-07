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
public class StringCollectorFixed implements Collector<String, StringCombinerFixed, String> {

    private final String delim;
    private final String prefix;
    private final String suffix;

    public StringCollectorFixed(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }
   
    @Override
    public Supplier<StringCombinerFixed> supplier() {
        return () -> new StringCombinerFixed(delim, prefix, suffix);
    }

    @Override
    public BiConsumer<StringCombinerFixed, String> accumulator() {
        return StringCombinerFixed::add;
    }

    @Override
    public BinaryOperator<StringCombinerFixed> combiner() {
        return StringCombinerFixed::merge;
    }

    @Override
    public Function<StringCombinerFixed, String> finisher() {
        return StringCombinerFixed::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Sets.newHashSet();
    }

}
