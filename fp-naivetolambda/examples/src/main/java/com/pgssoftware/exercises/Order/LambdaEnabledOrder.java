/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.Order;

import com.pgssoftware.Album;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.TreeMap;
import java.util.function.ToLongFunction;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

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
    
    public static TreeMap<String, List<String>> getAlbumsSummary(List<Album> albums) {
        
        return albums
                .stream()
                .sorted(comparing((Album a) -> a.musician).thenComparing((Album a) -> a.year).reversed())
                .collect(groupingBy(
                        (Album a) -> a.musician,
                        TreeMap::new,
                        mapping((Album e) -> String.format("%s - %s", e.name, e.year), toList())
                ));
    }
  
}
