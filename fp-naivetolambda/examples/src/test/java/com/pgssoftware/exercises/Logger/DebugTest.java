package com.pgssoftware.exercises.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pgssoftware.exercises.Logger.LoggerLambdaEnabled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author kuba
 */
@RunWith(MockitoJUnitRunner.class)
public class DebugTest {

    @Mock
    private Service externalService;
    
    @Test
    public void shouldPerformLoggingInDebugMode() {
        LoggerLambdaEnabled logger = new LoggerLambdaEnabled(true);

        logger.debug(() -> "External service called: " + getDebugInfoTimeConsuming());
        verify(externalService).getSymbols();

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
