/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.CustomCollector;

import com.pgssoftware.exercises.CustomCollector.ElementCombiner;
import java.math.BigDecimal;
import java.util.AbstractMap;
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
        implements Collector<AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, BigDecimal>>, ElementCombiner, Element> {

    @Override
    public Supplier<ElementCombiner> supplier() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return () -> new ElementCombiner();
    }

    @Override
    public BiConsumer<ElementCombiner, AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, BigDecimal>>> accumulator() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ElementCombiner::add;
    }

    @Override
    public BinaryOperator<ElementCombiner> combiner() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ElementCombiner::merge;
    }

    @Override
    public Function<ElementCombiner, Element> finisher() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ElementCombiner::getElement;
    }

    @Override
    public Set<Characteristics> characteristics() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new HashSet<>();
    }

}
