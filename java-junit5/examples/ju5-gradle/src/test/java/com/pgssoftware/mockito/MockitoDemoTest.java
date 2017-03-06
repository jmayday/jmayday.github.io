package com.pgssoftware.mockito;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MockitoDemoTest {

   private class Dummy {

       String getValueFromExternalService() {
           return "external service call here";
       }
   }

    @Mock
    private Dummy dummy;

    @BeforeEach
    void setUp() {
        when(dummy.getValueFromExternalService()).thenReturn("mocked");
    }

    @Test
    void testMockito() {
        assertEquals("mocked", dummy.getValueFromExternalService(),"external service assertion failed");
    }

    @Test
    void testMockitoInjectsParameters(@Mock Dummy injected) {
        assertNotNull(injected);
    }

}
