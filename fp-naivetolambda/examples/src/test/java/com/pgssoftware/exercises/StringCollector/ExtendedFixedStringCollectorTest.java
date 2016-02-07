package com.pgssoftware.exercises.StringCollector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static org.junit.Assert.*;
import org.junit.Test;

public class ExtendedFixedStringCollectorTest {

	@Test
	public void testIdentityConstraint() {
            // From javadoc of Collector interface:
            
            // The identity constraint says that for any partially accumulated result,
            // combining it with an empty result container must produce an equivalent result.
            // That is, for a partially accumulated result a that is the result of any series of 
            // accumulator and combiner invocations, a must be equivalent to combiner.apply(a, supplier.get()).

            StringCollectorFixed collector = new StringCollectorFixed(", ", "<!--", "-->");	
            Supplier<StringCombinerFixed> supplier = collector.supplier();
            BiConsumer<StringCombinerFixed, String> accumulator = collector.accumulator();
            BinaryOperator<StringCombinerFixed> combiner = collector.combiner();
            Function<StringCombinerFixed, String> finisher = collector.finisher();

            StringCombinerFixed stringCombiner1 = supplier.get();
            accumulator.accept(stringCombiner1, "one");
            accumulator.accept(stringCombiner1, "two");
            String result1 = finisher.apply(stringCombiner1);

            StringCombinerFixed stringCombiner2 = supplier.get();
            accumulator.accept(stringCombiner2, "one");
            accumulator.accept(stringCombiner2, "two");
            stringCombiner2 = combiner.apply(stringCombiner2, supplier.get());
            String result2 = finisher.apply(stringCombiner2);

            assertEquals(result1, result2);
	}
	
	@Test
	public void testAssociativityConstraint() {
            // From javadoc of Collector interface:
            
            // The associativity constraint says that splitting the computation must produce an equivalent result.

            StringCollectorFixed collector = new StringCollectorFixed(", ", "<!--", "-->");	
            Supplier<StringCombinerFixed> supplier = collector.supplier();
            BiConsumer<StringCombinerFixed, String> accumulator = collector.accumulator();
            BinaryOperator<StringCombinerFixed> combiner = collector.combiner();
            Function<StringCombinerFixed, String> finisher = collector.finisher();
		
            StringCombinerFixed a1 = supplier.get();
	    accumulator.accept(a1, "one");
	    accumulator.accept(a1, "two");
	    String r1 = finisher.apply(a1);  // result without splitting

	    StringCombinerFixed a2 = supplier.get();
	    accumulator.accept(a2, "one");
	    StringCombinerFixed a3 = supplier.get();
	    accumulator.accept(a3, "two");
	    String r2 = finisher.apply(combiner.apply(a2, a3));  // result with splitting
	    
	    assertEquals(r1,  r2);
	}
	
	@Test
	public void testCollectEmpty() {
            Stream<String> stream = Stream.of();
            String result = stream.collect(new StringCollectorFixed(", ", "<!--", "-->"));
            assertEquals("<!---->", result);
	}

	@Test
	public void testCollectSimple() {
            Stream<String> stream = Stream.of("one", "two", "three", "four");
            String result = stream.collect(new StringCollectorFixed(", ", "<!--", "-->"));
            assertEquals("<!--one, two, three, four-->", result);
	}

	@Test
	public void testCollectPrallel() {
            Stream<String> stream = Stream.of("one", "two", "three", "four");
            String result = stream.parallel().collect(new StringCollectorFixed(", ", "<!--", "-->"));
            assertEquals("<!--one, two, three, four-->", result);
	}

	@Test
	public void testCollectPrallelLargeDataSet() {
            System.out.println("testCollectParallelLargeDataSet");
            List<String> data = IntStream.iterate(1, i -> i + 1)
                                                 .mapToObj(Integer::toString)
                                                 .limit(1000)
                                                 .collect(Collectors.toList());

            String simpleResult = data.stream().collect(new StringCollectorFixed(", ", "<!--", "-->"));
            String parallelResult = data.parallelStream().collect(new StringCollectorFixed(", ", "<!--", "-->"));
            assertEquals(simpleResult, parallelResult);
	}

}