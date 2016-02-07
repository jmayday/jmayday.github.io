/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.Logger;

/**
 *
 * @author kuba
 */
public class LoggerNaive {
    
    private boolean debug = false;

    public boolean isDebug() {
        return debug;
    }
    
    public LoggerNaive(boolean isDebug) {
        this.debug = isDebug;
    }
    
    public void debug(String content) {
        if(debug) {
            // log content
        }
        
    }
}
