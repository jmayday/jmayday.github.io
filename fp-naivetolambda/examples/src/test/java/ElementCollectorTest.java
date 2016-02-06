/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pgssoftware.exercises.Element;
import com.pgssoftware.exercises.ElementCollector;
import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kuba
 */
public class ElementCollectorTest {
    
    public ElementCollectorTest() {
    }
    
    @Test
    public void shouldCreateElementsMap() {
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
        
        Map<Integer, Element> collect1 = (Map<Integer, Element>)Stream.of(
                jobs
                        .entrySet()
                        .stream()
                        .map(e -> new AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, BigDecimal>>("jobs", new AbstractMap.SimpleEntry(e))),
                maintenance
                        .entrySet()
                        .stream()
                        .map(e -> new AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, BigDecimal>>("maintenance", new AbstractMap.SimpleEntry(e))),
                service
                        .entrySet()
                        .stream()
                        .map(e -> new AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, BigDecimal>>("service", new AbstractMap.SimpleEntry(e)))
        )       
                
                .flatMap(f -> f)
                .collect(
                        groupingBy(e -> e.getValue().getKey(),
                                new ElementCollector())
                );
        
        
        System.out.println(collect1);
    }
    
}
