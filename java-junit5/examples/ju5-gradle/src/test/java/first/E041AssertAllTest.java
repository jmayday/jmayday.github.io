package first;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

public class E041AssertAllTest {

    @Test
    public void shouldReturnCollectionOfSizeWithFixedFirstElement() {
        List<String> actual = getActual();

        assertAll( "collection",
                () -> Assertions.assertEquals(3, actual.size(), "Size must be 3"),
                () -> Assertions.assertEquals("AZZ", actual.get(0), "AAA element must be first")
        );
    }

    private List<String> getActual() {
        List<String> result = new ArrayList<>(4);
        result.add("AAA");
        result.add("anything");
//        result.add("anything");
        return result;

    }


}
