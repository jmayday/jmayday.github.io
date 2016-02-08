/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.MyStringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author kuba
 */
public class MyStringUtilsReworked {
    

    public static List<String> trimmedUppercased(List<String> words) {
        return words.stream()
                .map(MyStringUtilsReworked::trimAndUppercase)
                .collect(Collectors.<String>toList());
    }      
    
    public static String trimAndUppercase(String value) {
        String trimmed = value.trim();
        char firstChar = Character.toUpperCase(trimmed.charAt(0));
        return firstChar + trimmed.substring(1);
    }
}
