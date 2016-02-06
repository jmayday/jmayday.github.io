
import com.pgssoftware.exercises.MyUtils;
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
public class FindLongestEntryTest {
    
    
    @Test
    public void shouldReturnLongestEntry() {
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney",
                "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe").parallel();

        Assertions.assertThat(MyUtils.findLongestEntry(names)).isEqualTo("Stuart Sutcliffe");
    }
}
