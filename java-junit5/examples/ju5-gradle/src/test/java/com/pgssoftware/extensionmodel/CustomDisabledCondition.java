package com.pgssoftware.extensionmodel;

import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.StringUtils;

import java.lang.reflect.AnnotatedElement;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

class CustomDisabledCondition implements ContainerExecutionCondition, TestExecutionCondition {

    /**
     * Containers are disabled if {@code @DisabledOnFriday} is present on the test class.
     */
    @Override
    public ConditionEvaluationResult evaluate(ContainerExtensionContext context) {
        return evaluate(context.getElement());
    }


    private ConditionEvaluationResult evaluate(Optional<AnnotatedElement> element) {

        Optional<CustomDisabled> annotation = AnnotationUtils.findAnnotation(element, CustomDisabled.class);

        if (annotation.isPresent() && LocalDateTime.now().getDayOfWeek() != DayOfWeek.MONDAY) {
            String reason = annotation
                    .map(CustomDisabled::value)
                    .filter(StringUtils::isNotBlank)
                    .orElseGet(() ->
                            element.get() + " has failed conditional checks - test is disabled");
            return ConditionEvaluationResult.disabled(reason);
        }

        return ConditionEvaluationResult.enabled(
                "conditional checks for " + element.get() + " passed - test is enabled"
        );
    }

    @Override
    public ConditionEvaluationResult evaluate(TestExtensionContext context) {
        return evaluate(context.getElement());
    }
}