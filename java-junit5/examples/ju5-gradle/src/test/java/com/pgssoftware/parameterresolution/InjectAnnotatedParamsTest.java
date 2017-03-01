package com.pgssoftware.parameterresolution;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyResolverByAnnotation.class)
@ExtendWith(MyResolver.class)
public class InjectAnnotatedParamsTest {

    @Test
    void shouldInjectAnnotatedParams(@ResolvableParam MyObject param, MyObject param2) {
        Assertions.assertThat(param).isNotNull();
        Assertions.assertThat(param.value).isNull();
        Assertions.assertThat(param2.value).isEqualToIgnoringCase("injected");


    }
}
