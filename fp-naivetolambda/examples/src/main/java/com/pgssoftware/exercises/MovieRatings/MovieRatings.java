/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.MovieRatings;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author kuba
 */
public class MovieRatings {
    
    private Map<String, Map<Integer, Set<String>>> ratings = new TreeMap<>();

    public Map<String, Map<Integer, Set<String>>> getRatings() {
        return ratings;
    }
    
    public void changeRating(String user, Integer rating, String movie) {

        ratings
                .computeIfAbsent(user, userRatings -> new TreeMap<>())
                .computeIfAbsent(rating, moviesOfRating -> new TreeSet<>())
                .add(movie);        
    }
    


}
