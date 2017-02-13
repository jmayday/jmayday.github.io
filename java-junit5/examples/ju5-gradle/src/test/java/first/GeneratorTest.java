package first;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Benchmark
class GeneratorTest {
    @DisplayName("when input is correct")
    @Nested
    class WhenInputIsCorrect {

        @Test
        @DisplayName("then generator returns combinations")
        void shouldGenerateCombinations() {

            String actual = "aaa";

            org.junit.jupiter.api.Assertions.assertAll(
                    () -> assertThat(actual).isEqualTo("aaa"),
                    () -> assertThat(actual).isEqualTo("aaa")
            );



//
//            assertAll("result",
//                    () -> assertThat(actual).isEqualTo("aab"),
//                    () -> assertThat(actual).isEqualTo("aaa"));
        }

    }
}
