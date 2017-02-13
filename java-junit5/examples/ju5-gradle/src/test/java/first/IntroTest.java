package first;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("fast")
@DisabledOnFriday
class IntroTest extends J5 {

    {

        λ("this should always return true", () -> {
            assertThat(isPgs()).isTrue();
        });

    }

    private boolean isPgs() {
        return true;
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @Test
    void test() {

    }
}
