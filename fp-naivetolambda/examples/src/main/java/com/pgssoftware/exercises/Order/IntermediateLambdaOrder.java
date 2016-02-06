/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.Order;

import com.pgssoftware.Album;
import java.util.List;

/**
 *
 * @author kuba
 */
public class IntermediateLambdaOrder {
    
    private List<Album> albums;
    
    public long countRunningTime() {
        return albums.stream()
                .mapToLong(album -> album
                                        .tracks
                                        .stream()
                                        .mapToLong(track -> track.length)
                                        .sum()
                 )
                .sum();
    }

    public long countMusicians() {
        return albums.stream()
                .mapToLong(album -> album
                        .performers
                        .stream()
                        .count()
                )
                .sum();
    }

    public long countTracks() {
        return albums.stream()
                .mapToLong(album -> album
                        .tracks
                        .stream()
                        .count()
                )
                .sum();
    }
}
