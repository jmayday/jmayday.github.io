package com.pgssoftware.lifecycle;

import org.junit.jupiter.api.*;


public class LifecycleInheritanceDemoTest {

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

    @org.junit.jupiter.api.Nested
    class Nested{


        @BeforeEach
        public void beforeEach() {
            System.out.println("\tnested beforeEach");
        }

        @AfterEach
        public void afterEach() {
            System.out.println("\tnested afterEach");
        }

        @Test
        void test() {
            System.out.println("\tnested testing");
        }
    }

    @org.junit.jupiter.api.Nested
    class AnotherNested{


        @BeforeEach
        public void beforeEach() {
            System.out.println("\tanother nested beforeEach");
        }

        @AfterEach
        public void afterEach() {
            System.out.println("\tanother nested afterEach");
        }

        @Test
        void test() {
            System.out.println("\tanother nested testing");
        }
    }
}
