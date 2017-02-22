package com.pgssoftware.assertall;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class VintageMultipleAssertsTest {

    @Test
    public void shouldReturnCollectionOfSizeWithFixedFirstElement() {
        List<String> actual = getActual();

        Assert.assertEquals("Size must be correct", 2, actual.size());
        Assert.assertEquals("AZZ element must be first", "AAA", actual.get(0));
    }

    private List<String> getActual() {
        List<String> result = new ArrayList<>(4);
        result.add("AAA");
        result.add("anything");
//        result.add("anything");
        return result;

    }


}
