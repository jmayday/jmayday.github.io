/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.CustomCollector.SideEffects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toSet;
import java.util.stream.Stream;

/**
 *
 * @author kuba
 */
public class SideEffects {

    public static List<String> mapToStringsBuggyNotSynchronized(Stream<Integer> source) {

        ArrayList<String> result = new ArrayList<>();
        source
            .map(i -> i.toString())
            .forEach(s -> result.add(s));  // Unnecessary use of side-effects!
        return result;
    }
    
    public static Set<String> mapToStringsBuggy(Stream<Integer> source) {

        Set<String> result = Collections.synchronizedSet(new HashSet<>());
        source
            .map(i -> i.toString())
            .forEach(s -> result.add(s));  // Unnecessary use of side-effects!
        return result;
    }
    
    public static Set<String> mapToStringsRecommendedWay(Stream<Integer> source) {
        
        return source
                .map(i -> i.toString())
                .collect(toSet());
    }
    
    public static ConcurrentMap<String, String> mapToStringsConcurrent(Stream<Integer> source) {
        
        return source
                .unordered()
                .map(i -> i.toString())
                .collect(Collectors.toConcurrentMap(i -> i, i -> i));
    }
}
