package com.pgssoftware;

import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.util.StringUtils;

import java.lang.reflect.AnnotatedElement;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

class DisabledOnFridayCondition implements ContainerExecutionCondition, TestExecutionCondition {

    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled(
            "@DisabledOnFriday is not present");

    /**
     * Containers are disabled if {@code @DisabledOnFriday} is present on the test class.
     */
    @Override
    public ConditionEvaluationResult evaluate(ContainerExtensionContext context) {
        return evaluate(context.getElement());
    }

    /**
     * Tests are disabled if {@code @DisabledOnFriday} is present on the test method.
     */
    @Override
    public ConditionEvaluationResult evaluate(TestExtensionContext context) {
        return evaluate(context.getElement());
    }

    private ConditionEvaluationResult evaluate(Optional<AnnotatedElement> element) {
        Optional<DisabledOnFriday> disabled = findAnnotation(element, DisabledOnFriday.class);
        if (disabled.isPresent() && LocalDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY) {
            String reason = disabled.map(DisabledOnFriday::value).filter(StringUtils::isNotBlank).orElseGet(
                    () -> element.get() + " is @DisabledOnFriday");
            return ConditionEvaluationResult.disabled(reason);
        }

        return ENABLED;
    }

}