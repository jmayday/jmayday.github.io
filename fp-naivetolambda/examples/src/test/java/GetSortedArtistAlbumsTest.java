/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pgssoftware.Album;
import com.pgssoftware.exercises.NewClass;
import static java.util.Arrays.asList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author kuba
 */
public class GetSortedArtistAlbumsTest {
    
    public GetSortedArtistAlbumsTest() {
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
     public void shouldReturnArtistAlbumsInSortedOrderAscByYear() {
         
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
//         a4.name = "Cementery gates EP";
//         a4.musician = "Pantera";
//         a4.year = 1990;
         
         
        List<Album> albums = asList(a1, a2, a3, a5, a4);
        NewClass c = new NewClass();
        
         
        //List<String> collection = asList("My", "name", "is", "John", "Doe");
        Map<String, List<String>> expected = new HashMap<String, List<String>>();
        
        assertThat(c.nameOfAlbums(albums)).containsOnlyKeys("Nirvana", "Alice in chains", "Pantera");
         System.out.println(c.nameOfAlbums(albums));
        //assertThat(transform(collection)).hasSameElementsAs(expected);
     
     }
}
