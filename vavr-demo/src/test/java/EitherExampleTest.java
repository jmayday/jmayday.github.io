import com.pgssoftware.either.EitherExample;
import org.junit.jupiter.api.Test;

public class EitherExampleTest {

    @Test
    void testProcess() {


        EitherExample testedService = new EitherExample();

        Long aLong = testedService.processWithEither(5);
        System.out.println(aLong);
    }
}
