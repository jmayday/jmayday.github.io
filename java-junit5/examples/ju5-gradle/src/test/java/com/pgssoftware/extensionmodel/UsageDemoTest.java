package com.pgssoftware.extensionmodel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class UsageDemoTest {

    private static final Logger logger = LogManager.getLogger(UsageDemoTest.class);

    @Test
    @CustomDisabled(value = "don't like this test")
    void assertThatResultIsNotEmpty() {
        org.assertj.core.api.Assertions.assertThat("s").isNotEmpty();
        logger.warn("executed");
    }

    @Test
    void assertThatResultIsNotEmpty2() {
        org.assertj.core.api.Assertions.assertThat("s").isNotEmpty();
        logger.warn("executed");
    }

    @Test
    @CustomDisabled
    void assertThatResultIsNotEmpty3() {
        org.assertj.core.api.Assertions.assertThat("s").isNotEmpty();
        logger.warn("executed");
    }
}
