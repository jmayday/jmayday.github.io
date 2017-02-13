package first;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E02LazyAssertionaMessageTest {

    @Test
    void shouldFind3Differences() {
        short expected = 3;
        short actual = 3;
        String assertionMessage = getAssertionMessage();
        assertEquals(expected, actual, assertionMessage);
    }

    @Test
    void shouldFind3DifferencesWithLambda() {
        short expected = 3;
        short actual = 3;
        assertEquals(expected, actual,() -> {
            return getAssertionMessage();
        });
    }

    private String getAssertionMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("must");
        sb.append(" find");
        sb.append(" 3 differences");
        System.out.println("assertion message has been computed. it was hard work.");
        return sb.toString();
    }


}
