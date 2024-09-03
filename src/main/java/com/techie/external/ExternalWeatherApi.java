package com.techie.external;

import com.techie.exceptions.WeatherServiceException;
import org.springframework.stereotype.Service;

@Service
public class ExternalWeatherApi {
    public String fetchWeatherData(String city) throws WeatherServiceException {
        if (Math.random() < 0.3) {
            throw new WeatherServiceException("External API failed");
        }
        return "Weather data for " + city;
    }
}
