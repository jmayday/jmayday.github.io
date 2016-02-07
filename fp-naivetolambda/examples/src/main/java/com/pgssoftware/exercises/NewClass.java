/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises;

import com.pgssoftware.exercises.StringCollector.StringCollectorFixed;
import com.pgssoftware.Album;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.*;
import java.util.HashMap;
import java.util.TreeMap;
import static java.util.stream.Collectors.groupingBy;

/**
 *
 * @author kuba
 */
public class NewClass {
    
    public static void main(String[] args) {
Album a1 = Album
                 .builder()
                 .name("In Utero")
                 .musician("Nirvana")
                 .year(1993)
                 .build();
         
//         a1.name = "In utero";
//         a1.musician = "Nirvana";
//         a1.year = 1994;
         
         
         Album a2 = Album
                 .builder()
                 .name("Dirt")
                 .musician("Alice in chains")
                 .year(1992)
                 .build();
         
//         a2.name = "Dirt";
//         a2.musician = "Alice in chains";
//         a2.year = 1992;
         
         Album a5 = Album
                 .builder()
                 .name("Man in the box EP")
                 .musician("Alice in chains")
                 .year(1990)
                 .build();
//         a5.name = "Man in the box EP";
//         a5.musician = "Alice in chains";
//         a5.year = 1990;
         
         Album a3 = Album
                 .builder()
                 .name("MTV unplugged")
                 .musician("Alice in chains")
                 .year(1996)
                 .build();
//         a3.name = "MTV unplugged";
//         a3.musician = "Alice in chains";
//         a3.year= 1996;
         
         Album a4 = Album
                 .builder()
                 .name("Cementery gates EP")
                 .musician("Pantera")
                 .year(1990)
                 .build();
         
         
        List<Album> albums = asList();
        
        Map<String, String> mapa = new HashMap<>();
        String computeIfAbsent = mapa.computeIfAbsent("kuba", NewClass::read);
        String computeIfAbsent2 = mapa.computeIfAbsent("kuba", NewClass::read);
        mapa.forEach((key, value) -> {
            System.out.println(String.format("%s: %s", key, value));
        });
        
        String collect = albums
                .stream()
                .map((Album a) -> a.name)
                .collect(new StringCollectorFixed(",", "[", "]"));
        
        String b = "asdf";
        
    }
    
    public static String read(String e) {
        return e+" read from db";
    }
    
    public Map<String, List<String>> nameOfAlbums(List<Album> albums) {
        System.out.println("comparing year");
        System.out.println(albums
                .stream()
                .sorted(comparing((Album a) -> a.year))
                .collect(toList()));
        System.out.println("comparing musician, then year");
        System.out.println(albums
                .stream()
                .sorted(comparing((Album a) -> a.musician).thenComparing((Album a) -> a.year))
                .collect(toList()));
        
        albums
                .stream()
                .map((Album a) -> a.name)
                .reduce(new StringBuilder(),
                        (builder, name) ->  {
                            builder.append(name); 
                            return builder;
                        },
                        (a,b)-> a.append(b));
        
        String collect = albums
                .stream()
                .map((Album a) -> a.name)
                .collect(new StringCollectorFixed(",", "[", "]"));
        
        
        return albums
                .stream()
                .sorted(comparing((Album a) -> a.musician).thenComparing((Album a) -> a.year))
                .collect(groupingBy(
                        (Album a) -> a.musician, 
                        TreeMap::new,
                        mapping((Album e) -> String.format("%s - %s" ,e.name, e.year), toList())
                ));
}
}
