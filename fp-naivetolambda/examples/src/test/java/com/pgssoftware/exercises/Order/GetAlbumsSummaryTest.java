/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.Order;

import com.pgssoftware.Album;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kuba
 */
public class GetAlbumsSummaryTest {
    
    public GetAlbumsSummaryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void shouldGetOrderSummary() {
                 Album a1 = Album
                 .builder()
                 .name("In Utero")
                 .musician("Nirvana")
                 .year(1993)
                 .build();
          
         Album a2 = Album
                 .builder()
                 .name("Dirt")
                 .musician("Alice in chains")
                 .year(1992)
                 .build();
         
         Album a5 = Album
                 .builder()
                 .name("Man in the box EP")
                 .musician("Alice in chains")
                 .year(1990)
                 .build();
 
         Album a3 = Album
                 .builder()
                 .name("MTV unplugged")
                 .musician("Alice in chains")
                 .year(1996)
                 .build();

         Album a4 = Album
                 .builder()
                 .name("Cementery gates EP")
                 .musician("Pantera")
                 .year(1990)
                 .build();

         
        List<Album> albums = asList(a1, a2, a3, a5, a4);
        TreeMap<String, List<String>> albumsSummary = LambdaEnabledOrder.getAlbumsSummary(albums);
        assertThat(albumsSummary).containsOnlyKeys("Nirvana", "Alice in chains", "Pantera");
        System.out.println(albumsSummary);
    }
}
