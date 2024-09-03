package com.techie.services;

import com.techie.exceptions.WeatherServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;

    @Test
    public void testWeatherService() {
        int successfulCalls = 0;
        int failedCalls = 0;
        int totalCalls = 100;

        for (int i = 0; i < totalCalls; i++) {
            try {
                String result = weatherService.getWeatherData("New York");
                assertNotNull(result);
                successfulCalls++;
            } catch (WeatherServiceException e) {
                log.warn("Weather service call failed: {}", e.getMessage());
                failedCalls++;
            }
        }

        assertTrue(successfulCalls >= 80,
                String.format("Expected at least 80 successful calls, but got %d successful and %d failed",
                        successfulCalls, failedCalls));
    }
}