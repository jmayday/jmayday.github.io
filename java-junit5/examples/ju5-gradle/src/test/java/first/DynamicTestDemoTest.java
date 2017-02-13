package first;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kuba on 08.02.17.
 */
public class DynamicTestDemoTest {

    @TestFactory
    List<DynamicTest> getTests() {
        List<DynamicTest> first = Arrays.asList(
                DynamicTest.dynamicTest("first", () -> {
                    Assertions.assertEquals(5, 5, () -> "should be equal");
                }), DynamicTest.dynamicTest("second", () -> {
                    Assertions.assertEquals(5, 5, () -> "should be equal");
                })
        );

        return first;

    }
}
