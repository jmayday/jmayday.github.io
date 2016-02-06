/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;




public class PartialStreamApiUseExample {
    
    public static void main(String... args) {
        ArrayList<Album> arrayList = prepareTestDataset();
        
        Set<String> findLongTracks = findLongTracks(arrayList);
        System.out.println("\nfindLongTracks:");
        findLongTracks
                .forEach(System.out::println);
        
        Set<String> findLongTracksOnStreamsBetterOne = findLongTracksOnStreamsBetterOne(arrayList);
        System.out.println("\nfindLongTracksOnStreamsBetterOne:");
        findLongTracksOnStreamsBetterOne
                .forEach(System.out::println);
        
    }

    private static ArrayList<Album> prepareTestDataset() {
        Album first = Album.builder().build();
        Track t1 = new Track("a1shortTrack", 15);
        Track t2 = new Track("a1longTrack", 66);
        first.tracks = Arrays.asList(t1, t2);
        Album second = Album.builder().build();
        Track t21 = new Track("a2shortTrack", 25);
        Track t22 = new Track("a2longTrack", 56);
        second.tracks = Arrays.asList(t21, t22);
        Album third = Album.builder().build();
        Track t31 = new Track("a3shortTrack", 45);
        Track t32 = new Track("a3longTrack", 76);
        third.tracks = Arrays.asList(t31, t32);
        final ArrayList<Album> arrayList = new ArrayList<>(Arrays.asList(first,second,third));
        return arrayList;
    }
    
    
    
    
    public static Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            for(Album album : albums) {
                    for (Track track : album.tracks) {
                            if (track.length > 60) {
                                    String name = track.name;
                                    trackNames.add(name);
                            }
                    }
            }
            return trackNames;
    }

    public Set<String> findLongTracksOnStreams(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream()
            .forEach(album -> {
                    album.tracks
                    .forEach(track -> {
                            if (track.length > 60) {
                                    String name = track.name;
                                    trackNames.add(name);
                            }
                    });
            });
            return trackNames;
    }
    
    public static Set<String> findLongTracksOnStreamsBetterOne(List<Album> albums) {
        return albums
                .stream()
                .flatMap(album -> album.tracks.stream())
                .filter(track -> track.length > 60)
                .map(track -> track.name)
                .collect(Collectors.toSet());
        
                
    }
}
