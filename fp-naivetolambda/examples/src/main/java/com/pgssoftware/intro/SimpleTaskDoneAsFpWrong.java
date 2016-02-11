/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.intro;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kuba
 */
public class SimpleTaskDoneAsFpWrong {
    
    public static void main(String[] args) {    
        for (Object o : take(25, squaresOf(integers()))) {
            System.out.println(o);
        }
    }
    
    public static List<?> take(int n, List<?> list) {
        return list.subList(0, n);
    }
    
    public static List<Integer> squaresOf(List<Integer> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (Integer number : list) {
            result.add(number.intValue() * number.intValue());
        }
        return result;
    }
    
    public static List<Integer> integers() {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            result.add(i);
        }
        return result;
    }
}
