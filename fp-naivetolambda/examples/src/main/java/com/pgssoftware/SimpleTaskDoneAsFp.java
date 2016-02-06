/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware;

import java.util.stream.IntStream;

/**
 *
 * @author kuba
 */
public class SimpleTaskDoneAsFp {
    
    public static void main(String[] args) {    
        IntStream
                .range(1, 26)
                .map(i -> i * i)
                .forEach(System.out::println);
    }
    

}
