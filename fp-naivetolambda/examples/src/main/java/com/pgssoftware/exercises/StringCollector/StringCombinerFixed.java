/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.StringCollector;

/**
 *
 * @author kuba
 */
public class StringCombinerFixed {

    StringBuilder builder;
    private final String delim;
    private final String prefix;
    private final String suffix;

    public StringCombinerFixed(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
        builder = new StringBuilder();
    }

    public StringCombinerFixed add(String element) {
        if (areAtStart()) {
            builder.append(prefix);
        } else {
            builder.append(delim);
        }
        builder.append(element);
        return this;
    }

    public StringCombinerFixed merge(StringCombinerFixed other) {
        if (other.builder.length() > 0) {
            if (areAtStart()) {
                builder.append(prefix);
            } else {
                builder.append(delim);
            }
            builder.append(other.builder, prefix.length(), other.builder.length());
        }
        return this;
    }

    private boolean areAtStart() {
        return builder.length() == 0;
    }

    @Override
    public String toString() {
        if (areAtStart()) {
                builder.append(prefix);
        }
        builder.append(suffix);
        return builder.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
