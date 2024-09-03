package com.techie.services.impl;

import com.techie.model.UserModel;
import com.techie.services.ProcessorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProcessorServiceImplTest {

    @Autowired
    private ProcessorService processorService;

    @Test
    void testUserDataProcessing() {
        List<String> inputLines = Arrays.asList(
                "John Doe,john@example.com,25,500000",
                "Alice Smith,alice@example.com,17,100000",
                "Bob Johnson,bobjohnson,30,2000000",
                "Anna Brown,anna@example.com,22,1500000"
        );

        List<UserModel> processedUsers = processorService.processUsers(inputLines);

        assertEquals(4, processedUsers.size());

        UserModel john = processedUsers.get(0);
        assertEquals("John Doe", john.getName());
        assertEquals("john@example.com", john.getEmail());
        assertEquals(25, john.getAge());
        assertEquals(new BigDecimal("500000"), john.getNetWorth());

        UserModel alice = processedUsers.get(1);
        assertEquals("ALICE SMITH", alice.getName());
        assertEquals("alice@example.com", alice.getEmail());
        assertEquals(18, alice.getAge());
        assertEquals(new BigDecimal("100000"), alice.getNetWorth());

        UserModel bob = processedUsers.get(2);
        assertEquals("Bob Johnson (Millionaire)", bob.getName());
        assertEquals("bobjohnson@default.com", bob.getEmail());
        assertEquals(30, bob.getAge());
        assertEquals(new BigDecimal("2000000"), bob.getNetWorth());

        UserModel anna = processedUsers.get(3);
        assertEquals("ANNA BROWN (Millionaire)", anna.getName());
        assertEquals("anna@example.com", anna.getEmail());
        assertEquals(22, anna.getAge());
        assertEquals(new BigDecimal("1500000"), anna.getNetWorth());
    }
}
