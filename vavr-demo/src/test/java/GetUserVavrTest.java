import com.pgssoftware.model.User;
import com.pgssoftware.service.UserRepository;
import com.pgssoftware.service.UserService;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Try;
import org.assertj.vavr.api.VavrAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GetUserVavrTest {


    private UserService testedService;
    private UserRepository repository;

    @BeforeEach
    void setup() {
        repository = new UserRepository();
        testedService = new UserService(repository);
    }

    @DisplayName("Finds user")
    @ParameterizedTest(name = "Finds user of id {arguments}")
    @MethodSource("generator")
    void shouldFindUser(Tuple2<Long, Try<User>> tuple) {

        Try<User> expected = tuple._2();
        Try<User> actual = testedService.getUserVavr(tuple._1());

        if (expected.isSuccess()) {
            VavrAssertions.assertThat(actual).contains(expected.get());
        }
        if (expected.isFailure()) {
            VavrAssertions.assertThat(actual).failBecauseOf(expected.getCause().getClass());
            VavrAssertions.assertThat(actual).failReasonHasMessage(expected.getCause().getMessage());
        }
    }

    static Stream<Tuple2> generator() {

        return Stream.of(
                Tuple.of(1L, Try.success(User.builder().id(1).build())),
                Tuple.of(2L, Try.success(User.builder().id(2).build())),
                Tuple.of(3L, Try.success(User.builder().id(3).build())),
                Tuple.of(1001L, Try.failure(new Exception("User with id 1001 not found"))));


    }
}
