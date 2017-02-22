package com.pgssoftware.news;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class AssertEquals {

    protected String getAssertionMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("must");
        sb.append(" find");
        sb.append(" 3 differences");
        System.out.println("assertion message has been computed. it was hard work.");
        return sb.toString();
    }

}
