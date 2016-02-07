/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.MyStringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author kuba
 */
public class MyStringUtils {
    
    
    public static String findLongestEntry(Collection<String> coll) {

        return coll
                .stream()
                .reduce(StringUtils.EMPTY, (a, b) -> {
                    return StringUtils.length(a) > StringUtils.length(b) ? a : b;
                });
            
    }
    
    public static Map<String, Long> getCardinality(Collection<String> coll) {

        return coll
                .stream()
                .collect(Collectors.groupingBy(e -> e, counting()));
    }
}
