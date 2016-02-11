/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.intro;

    //Here’s a bit of Clojure (a real functional language) that returns a list of the first 25 integers:
    //
    //(take 25 (squares-of (integers)))
    //
    //This code runs, and it runs reasonably quickly. The output is:
    //
    //(1 4 9 16 25 36 49 64 … 576 625)
    //
    //Now suppose we want to reproduce this in Java. If we write Java the way Gosling et al intended Java to be written, then the code is simple, fast, and obvious:

public class SimpleTaskDoneClassicWayInJava {
    
    public static void main(String... args) {

    for (int i=1; i<=25; i++)
        System.out.println(i*i);
    }
    
}
