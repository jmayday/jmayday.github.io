
import edu.emory.mathcs.backport.java.util.Collections;
import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy; 
import static java.util.stream.Collectors.mapping;
import java.util.stream.Stream;
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
public class MapStructuresTest {
    
    @Test
    public void shouldMapStructures() {
        
        Map<Integer, BigDecimal> jobs = new HashMap(); 
        jobs.put(Integer.valueOf("1"), new BigDecimal("1.0"));
        jobs.put(Integer.valueOf("2"), new BigDecimal("2.0"));
        jobs.put(Integer.valueOf("3"), new BigDecimal("3.0"));
        
        Map<Integer, BigDecimal> maintenance = new HashMap(); 
        maintenance.put(Integer.valueOf("1"), new BigDecimal("10.0"));
        maintenance.put(Integer.valueOf("2"), new BigDecimal("20.0"));
        maintenance.put(Integer.valueOf("4"), new BigDecimal("30.0"));
        
        Map<Integer, BigDecimal> service = new HashMap(); 
        service.put(Integer.valueOf("1"), new BigDecimal("100.0"));
        service.put(Integer.valueOf("2"), new BigDecimal("200.0"));
        service.put(Integer.valueOf("5"), new BigDecimal("300.0"));
        
        Map<String,Map<Integer, BigDecimal>> merged = new HashMap();
        merged.put("jobs", jobs);
        merged.put("maintenance", maintenance);
        merged.put("service", service);
        
        Stream<AbstractMap.SimpleEntry<String, SimpleEntry<Integer, BigDecimal>>> sjobs = jobs.entrySet().stream()
                .map(e -> new SimpleEntry<String, SimpleEntry<Integer, BigDecimal>>("jobs", new SimpleEntry<Integer, BigDecimal>(e)));
        Stream<SimpleEntry<String, SimpleEntry<Integer, BigDecimal>>> smaintenance = maintenance.entrySet().stream()
                .map(e -> new AbstractMap.SimpleEntry<String, SimpleEntry<Integer, BigDecimal>>("maintenance", new SimpleEntry<Integer, BigDecimal>(e)));
        Stream<SimpleEntry<String, SimpleEntry<Integer, BigDecimal>>> sservice = service.entrySet().stream()
                .map(e -> new AbstractMap.SimpleEntry<String, SimpleEntry<Integer, BigDecimal>>("service", new SimpleEntry<Integer, BigDecimal>(e)));
        
        
        
        
        Stream<Stream<AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, BigDecimal>>>> of = Stream.of(sjobs, smaintenance, sservice);
        
        Stream<SimpleEntry<String, SimpleEntry<Integer, BigDecimal>>> flatMap = of.flatMap(e -> e);
        
        Map<Integer, Map<String, List<BigDecimal>>> collect = flatMap
                .collect(
                        groupingBy(e -> e.getValue().getKey(),
                                mapping(f -> f,
                                        groupingBy(e -> e.getKey(), 
                                                mapping(e -> e.getValue().getValue(), Collectors.toList()))
                                )
                        )
                );
        
        System.out.println(collect);
        
//        Map<Integer, Map<String, BigDecimal>> collectSimple = Stream.of(
//                jobs
//                    .entrySet()
//                    .stream()
//                    .map(e -> new SimpleEntry<String, SimpleEntry<Integer, BigDecimal>>("jobs", new SimpleEntry(e))),
//                maintenance
//                    .entrySet()
//                    .stream()
//                    .map(e -> new SimpleEntry<String, SimpleEntry<Integer, BigDecimal>>("maintenance", new SimpleEntry(e))),
//                service
//                    .entrySet()
//                    .stream()
//                    .map(e -> new SimpleEntry<String, SimpleEntry<Integer, BigDecimal>>("service", new SimpleEntry(e)))
//                )
//                .flatMap(f -> f)
////                .sorted(comparing(
////                        (SimpleEntry<String, SimpleEntry<Integer, BigDecimal>> e) -> e.getValue().getKey())
////                        .thenComparing((SimpleEntry<String, SimpleEntry<Integer, BigDecimal>> e) -> e.getValue().getValue()).reversed()
////                )
//                .collect(
//                        groupingBy(e -> e.getValue().getKey(),
//                                () -> new TreeMap(Collections.reverseOrder()),
//                                mapping(f -> f,
//                                        toMap(e -> e.getKey(),
//                                                e -> e.getValue().getValue()/*, (a, b) -> a, TreeMap::new*/))
//                        )
//                );
//                
//        System.out.println(collectSimple);
        

    }

    
    private static class ReversedMap extends TreeMap {

        public ReversedMap() {
            super(Collections.reverseOrder());
        }
        
        //return new TreeMap(Collections.reverseOrder());
    }
}
