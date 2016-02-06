/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.Order;

import com.pgssoftware.Album;
import com.pgssoftware.Track;
import java.util.List;

/**
 *
 * @author kuba
 */
public class NaiveOrder {

    private List<Album> albums;

    public long countRunningTime() {
        long count = 0;
        for (Album album : albums) {
            for (Track track : album.tracks) {
                count += track.length;
            }
        }
        return count;
    }
    
    public long countMusicians() {
        long count = 0;
        for (Album album : albums) {
            count += album.performers.size();
        }
        return count;
    }

    public long countTracks() {
        long count = 0;
        for (Album album : albums) {
            count += album.tracks.size();
        }
        return count;
    }
}
