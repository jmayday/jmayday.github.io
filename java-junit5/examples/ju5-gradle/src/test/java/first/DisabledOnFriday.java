package first;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.meta.API;

import java.lang.annotation.*;

import static org.junit.platform.commons.meta.API.Usage.Stable;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ExtendWith(DisabledOnFridayCondition.class)
public @interface DisabledOnFriday {

    String value() default "";
}
