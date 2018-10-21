import com.pgssoftware.service.UserRepository;
import com.pgssoftware.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GetUserTest {


    private UserService testedService;
    private UserRepository repository;

    @BeforeEach
    void setup() {
        repository = new UserRepository();
        testedService = new UserService(repository);
    }

    @DisplayName("Finds user")
    @ParameterizedTest(name = "Finds user of id {arguments}")
    @ValueSource(longs = {1, 2, 3})
    void shouldFindUser(long id) {
        Assertions.assertThat(testedService.getUser(id).getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("Throws exception if user doesn't exist")
    void shouldThrowException() {
        Assertions.assertThatThrownBy(() -> testedService.getUser(1001L))
                .isInstanceOf(RuntimeException.class);
    }
}
