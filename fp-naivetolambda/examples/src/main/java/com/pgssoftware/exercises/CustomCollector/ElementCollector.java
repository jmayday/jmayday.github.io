/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.CustomCollector;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
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
public class ElementCollector
        implements Collector<SimpleEntry<Type, SimpleEntry<Integer, BigDecimal>>, ElementCombiner, FormElement> {

    @Override
    public Supplier<ElementCombiner> supplier() {
        return () -> new ElementCombiner();
    }

    @Override
    public BiConsumer<ElementCombiner, AbstractMap.SimpleEntry<Type, AbstractMap.SimpleEntry<Integer, BigDecimal>>> accumulator() {
        return ElementCombiner::add;
    }

    @Override
    public BinaryOperator<ElementCombiner> combiner() {
        return ElementCombiner::merge;
    }

    @Override
    public Function<ElementCombiner, FormElement> finisher() {
        return ElementCombiner::getElement;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>();
    }

}
