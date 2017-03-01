package com.pgssoftware.parameterresolution;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyResolver.class)
public class InjectParamsTest {

    @org.junit.jupiter.api.Test
    void shouldInjectParams(MyObject object) {
        Assertions.assertThat(object.value).isEqualToIgnoringCase("injected");

    }


}
