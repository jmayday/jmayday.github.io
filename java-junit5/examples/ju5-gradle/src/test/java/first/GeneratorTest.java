package first;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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
