package com.pgssoftware.exercises.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author kuba
 */
@RunWith(MockitoJUnitRunner.class)
public class DebugTestWithSomeExtensions {

    @Mock
    private Service externalService;
    
    @Before
    public void setUp() throws Exception {
        
//        when(externalService.getSymbols()).thenAnswer(new Answer<String>() {
//            @Override
//            public String answer(InvocationOnMock invocation) throws Throwable {
//                return "LLL2016XX21";
//            }
//        });
        
        when(externalService.getSymbols()).thenAnswer((InvocationOnMock iom) -> "LLL2016XX21");
    }
    
    @Test
    public void shouldPerformLoggingInDebugMode() {
        LoggerLambdaEnabled logger = Mockito.spy(new LoggerLambdaEnabled(true));
        logger.debug(() -> "External service called: " + getDebugInfoTimeConsuming());
        
        verify(logger).debug("External service called: LLL2016XX21");
    }
    
    @Test
    public void shouldNotPerformLoggingInNonDebugMode() {
        LoggerLambdaEnabled logger = new LoggerLambdaEnabled(false);
        logger.debug(() -> "External service called: " + getDebugInfoTimeConsuming());
        
        verify(externalService, never()).getSymbols();
    }
    
    private String getDebugInfoTimeConsuming() {
        return externalService.getSymbols();
    }
    
}
