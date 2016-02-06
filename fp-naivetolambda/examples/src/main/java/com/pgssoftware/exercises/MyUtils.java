/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises;

import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.plexus.util.CollectionUtils;

/**
 *
 * @author kuba
 */
public class MyUtils {
    
    
    public static String findLongestEntry(Stream<String> stream) {

        return stream
                .reduce(StringUtils.EMPTY, (a, b) -> {
                    return StringUtils.length(a) > StringUtils.length(b) ? a : b;
                });
            
    }
    
    public static Map<String, Long> getCardinality(Stream<String> stream) {
        // CollectionUtils.getCardinalityMap(col)
        
        return stream
                .collect(Collectors.groupingBy(e -> e, counting()));
    }
}
