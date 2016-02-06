/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author kuba
 */
public class FunctionalProgramming {

    private static boolean isEven(int number) {
            return number % 2 == 0;
        }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

        
        List<Integer> values = Arrays.asList(2, 1, 3, 3, 3, 5, 7, 8);
        
        int result = 0;
        for(Integer value : values) {
            if( value > 3 && value % 2 == 0) {
                result = value *2;
                System.out.println(result);
                break;
            }
        }
        
        Predicate<Integer> isGreaterThan3 = number -> number > 3;
        Function<Integer, Predicate<Integer>> isGreatherThan = pivot -> 
                number -> number > pivot;

    

        System.out.println(
                values.stream()
                .filter(isGreatherThan.apply(3))
                .filter(FunctionalProgramming::isEven)
                .map(e -> e * 2)
                .findFirst()
        );
        
    }
    
}
