/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author kuba
 */
public class NewClass {
    
    public static void main(String[] args) {

        
        Map<String, String> mapa = new HashMap<>();
        String computeIfAbsent = mapa.computeIfAbsent("kuba", NewClass::read);
        String computeIfAbsent2 = mapa.computeIfAbsent("kuba", NewClass::read);
        
    }
    
    public static String read(String e) {
        return e+" read from db";
    }

}
