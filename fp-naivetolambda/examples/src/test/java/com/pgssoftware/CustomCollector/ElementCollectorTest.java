package com.pgssoftware.CustomCollector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.common.collect.ImmutableMap;
import com.pgssoftware.exercises.CustomCollector.ElementCollector;
import com.pgssoftware.exercises.CustomCollector.FormElement;
import com.pgssoftware.exercises.CustomCollector.Type;
import java.math.BigDecimal;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.stream.Collectors.groupingBy;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

/**
 *
 * @author kuba
 */
public class ElementCollectorTest {
    
    public ElementCollectorTest() {
    }
    
    @Test
    public void shouldCreateElementsMap() {
        
        Map<Integer, BigDecimal> jobs, maintenance, service;
        
        jobs = ImmutableMap.of(
                Integer.valueOf("1"), new BigDecimal("1.0"),
                Integer.valueOf("2"), new BigDecimal("2.0"),
                Integer.valueOf("3"), new BigDecimal("3.0"));

        maintenance = ImmutableMap.of(
                Integer.valueOf("1"), new BigDecimal("10.0"),
                Integer.valueOf("2"), new BigDecimal("20.0"),
                Integer.valueOf("4"), new BigDecimal("30.0"));

        service = ImmutableMap.of(
                Integer.valueOf("1"), new BigDecimal("100.0"),
                Integer.valueOf("2"), new BigDecimal("200.0"),
                Integer.valueOf("5"), new BigDecimal("300.0"));
        
        // cast required for java-8-openjdk
        Map<Integer, FormElement> myStructureOfFormElements = (Map<Integer, FormElement>)Stream.of(
                jobs
                    .entrySet()
                    .stream()
                    .map(e -> entry(Type.JOBS, e)),
                maintenance
                    .entrySet()
                    .stream()
                    .map(e -> entry(Type.MAINTENANCE, e)),
                service
                    .entrySet()
                    .stream()
                    .map(e -> entry(Type.SERVICE, e))
        )             
        .flatMap(f -> f)
        .collect(
                groupingBy(e -> e.getValue().getKey(),
                        new ElementCollector())
        );
        
        
        assertThat(myStructureOfFormElements).containsOnlyKeys(1,2,3,4,5);
        FormElement fe2 = FormElement
                .builder()
                .jobs(new BigDecimal("2.0"))
                .maintenance(new BigDecimal("20.0"))
                .service(new BigDecimal("200.0"))
                .build();
        FormElement fe5 = FormElement
                .builder()
                .service(new BigDecimal("300.0"))
                .build();
        
        assertThat(myStructureOfFormElements).containsEntry(2, fe2);
        assertThat(myStructureOfFormElements).containsEntry(5, fe5);
        
        
        //System.out.println(myStructureOfFormElements);
    }
    
    private static SimpleEntry<Type, SimpleEntry<Integer, BigDecimal>> entry(Type type, Entry<Integer, BigDecimal> nested) {
        return new SimpleEntry<>(type, new SimpleEntry(nested));
    }
    
}
