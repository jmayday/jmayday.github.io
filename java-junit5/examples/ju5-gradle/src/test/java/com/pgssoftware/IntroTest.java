package com.pgssoftware;

import static org.assertj.core.api.Assertions.assertThat;

class IntroTest extends J5 {

    {
        λ("this should always return true", () -> {
            assertThat(isPgs()).isTrue();
        });

    }

    private boolean isPgs() {
        return true;
    }

}
