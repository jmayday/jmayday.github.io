package com.pgssoftware.nested;

import com.pgssoftware.extensionmodel.Benchmark;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Benchmark
class JupiterNestingTest {

    @DisplayName("when input is correct")
    @Nested
    class Correct {

        @Test
        @DisplayName("generator returns unique combinations")
        void uniqueness() {

            String actual = "aaa";

            org.junit.jupiter.api.Assertions.assertAll(
                    () -> assertThat(actual).isEqualTo("aaa"),
                    () -> assertThat(actual).isEqualTo("aaa")
            );
        }

        @Test
        @DisplayName("multiple calls with same parameters give same results")
        void stable() {

        }

        @Test
        @DisplayName("generator is able to start at given sequence")
        void canContinue() {

        }

    }

    @DisplayName("when input is incorrect")
    @Nested
    class Incorrect {

        @Test
        @DisplayName("generator handles nulls")
        void handlesNulls() {

            String actual = "aaa";

            org.junit.jupiter.api.Assertions.assertAll(
                    () -> assertThat(actual).isEqualTo("aaa"),
                    () -> assertThat(actual).isEqualTo("aaa")
            );
        }

        @Test
        @DisplayName("generator gives verbose output")
        void stable() {

        }


    }
}
