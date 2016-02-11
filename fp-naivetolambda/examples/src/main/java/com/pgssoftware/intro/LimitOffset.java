/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.intro;

import java.util.stream.IntStream;

/**
 *
 * @author kuba
 */
public class LimitOffset {
    public static void main(String... args) {
        
    IntStream.iterate(0, i -> i + 1)
            .skip(5)   // OFFSET
             .limit(10) // LIMIT
             
             .forEach(System.out::println);
    }
}
