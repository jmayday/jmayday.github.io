/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.StreamUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 * @author kuba
 */
public class StreamUtilsFixed {

    public static <T, R> List<R> map(Stream<T> stream, Function<T, R> mapper) {
        return stream.reduce(new ArrayList<>(), (acc, value) -> {
            // Make copy of list (modifying acc would violate contract of reduce method) 
            ArrayList<R> result = new ArrayList<>();
            result.addAll(acc);
            result.add(mapper.apply(value));
            return result;
        }, (left, right) -> {
            ArrayList<R> result = new ArrayList<>();
            result.addAll(left);
            result.addAll(right);
            return result;

        });
    }
}
