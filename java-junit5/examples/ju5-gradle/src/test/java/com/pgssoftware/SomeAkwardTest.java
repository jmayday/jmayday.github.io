package com.pgssoftware;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;


@OurTest
@DisabledOnFriday
public class SomeAkwardTest {

    private static final Logger logger = LogManager.getLogger(SomeAkwardTest.class);

    @Test
    void assertThatResultIsNotEmpty() {
        org.assertj.core.api.Assertions.assertThat("s").isNotEmpty();
        logger.warn("executed");
    }
}
