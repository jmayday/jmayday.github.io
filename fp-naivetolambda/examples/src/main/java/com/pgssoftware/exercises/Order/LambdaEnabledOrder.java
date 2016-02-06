/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.Order;

import com.pgssoftware.Album;
import java.util.List;
import java.util.function.ToLongFunction;

/**
 *
 * @author kuba
 */
public class LambdaEnabledOrder {
    
    private List<Album> albums;
    
    public long count(ToLongFunction<Album> f) {
        return albums
               .stream()
                    .mapToLong(f)
                    .sum();
    }
    
    public long countRunningTime() {
        return count(a -> a
                .tracks
                .stream()
                    .mapToLong(track -> track.length)
                    .sum()
        );
    }

    public long countMusicians() {
        return count(a -> a
                .performers
                .stream()
                    .count()
        );
    }

    public long countTracks() {
        return count(a -> a.tracks.stream().count());
    }
  
}
