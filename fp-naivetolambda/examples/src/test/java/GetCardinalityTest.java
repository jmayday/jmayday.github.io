
import com.pgssoftware.exercises.MyUtils;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kuba
 */
public class GetCardinalityTest {
    
    
    @Test
    public void shouldCountEntries() {
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");

        Map<String, Long> cardinality = MyUtils.getCardinality(names);
        
        Assertions.assertThat(cardinality).containsEntry("John", 3L);
        Assertions.assertThat(cardinality).containsEntry("Paul", 2L);
        Assertions.assertThat(cardinality).containsEntry("George", 1L);
    }
    
}
