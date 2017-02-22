package com.pgssoftware.lifecycle;

import org.junit.jupiter.api.*;

public class NewLifecycleNamesTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }

    @Test
    void test() {
        System.out.println("testing");
    }
}
