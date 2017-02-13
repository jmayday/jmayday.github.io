package first;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class E01NewAssertEqualsOrderTest {

    @Test
    void shouldFind3Differences() {
        short expected = 3;
        short actual = 3;
        String assertionMessage = getAssertionMessage();
        assertEquals(expected, actual, assertionMessage);
    }

    private String getAssertionMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("must");
        sb.append(" find");
        sb.append(" 3 differences");
        return sb.toString();
    }


}
