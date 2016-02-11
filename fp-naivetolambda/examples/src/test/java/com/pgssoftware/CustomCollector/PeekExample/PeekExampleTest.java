/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.CustomCollector.PeekExample;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 *
 * @author kuba
 */
public class PeekExampleTest {


    @Test
    public void hello() {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
}
