/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.Logger;

import java.util.function.Supplier;

public class LoggerLambdaEnabled {

    public LoggerLambdaEnabled(boolean isDebug) {
        this.isDebug = isDebug;
    }

    private boolean isDebug = false;
    
    public void debug(Supplier<String> function) {
        if(isDebug) {
            debug(function.get());
        }
    }
    
    public void debug(String content) {
        
    }
}
