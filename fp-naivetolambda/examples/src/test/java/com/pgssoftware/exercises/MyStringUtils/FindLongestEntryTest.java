package com.pgssoftware.exercises.MyStringUtils;


import java.util.Arrays;
import java.util.Collection;
import static org.assertj.core.api.StrictAssertions.assertThat;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kuba
 */
public class FindLongestEntryTest {
    
    
    @Test
    public void shouldReturnLongestEntry() {
        Collection<String> names = Arrays.asList("John Lennon", "Paul McCartney",
                "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
        
        String actual = MyStringUtils.findLongestEntry(names);
        String expected = "Stuart Sutcliffe";
        
        assertThat(actual).isEqualTo(expected);
    }
}
