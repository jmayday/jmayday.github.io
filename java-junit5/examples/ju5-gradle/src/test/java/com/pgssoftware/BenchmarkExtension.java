package com.pgssoftware;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExtensionContext;

import java.util.HashMap;
import java.util.Map;

public class BenchmarkExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private long l;

    @Override
    public void beforeTestExecution(TestExtensionContext context) throws Exception {
        getStore(context).put(context.getTestMethod().get(), System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(TestExtensionContext context) throws Exception {
        long elapsed = System.currentTimeMillis() - getStore(context).remove(context.getTestMethod().get(), long.class);
        String message = String.format("Test %s took %d ms.%n", context.getTestMethod().get().getName(), elapsed);
        context.publishReportEntry(
                createMapWithPair("Benchmark", message));

    }

    private Map<String,String> createMapWithPair(String benchmark, String message) {
        Map<String,String> map = new HashMap<>();
        map.put(benchmark, message);
        return map;

    }

    private ExtensionContext.Store getStore(TestExtensionContext context) {
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context));
    }
}
