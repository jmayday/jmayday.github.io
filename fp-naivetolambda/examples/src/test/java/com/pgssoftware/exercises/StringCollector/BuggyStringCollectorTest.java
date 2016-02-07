package com.pgssoftware.exercises.StringCollector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.stream.Stream;
import static org.junit.Assert.*;
import org.junit.Test;

public class BuggyStringCollectorTest {

	@Test
	public void testCollectEmpty() {
            Stream<String> stream = Stream.of();
            String result = stream.collect(new StringCollectorBuggy(", ", "<!--", "-->"));
            assertEquals("<!---->", result);
	}

	@Test
	public void testCollectSimple() {
            Stream<String> stream = Stream.of("one", "two", "three", "four");
            String result = stream.collect(new StringCollectorBuggy(", ", "<!--", "-->"));
            assertEquals("<!--one, two, three, four-->", result);
	}

}