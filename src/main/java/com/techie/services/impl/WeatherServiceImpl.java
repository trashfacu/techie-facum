package com.techie.services.impl;

import com.techie.exceptions.WeatherServiceException;
import com.techie.external.ExternalWeatherApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techie.services.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final ExternalWeatherApi externalWeatherApi;

    @Autowired
    public WeatherServiceImpl(ExternalWeatherApi externalWeatherApi) {
        this.externalWeatherApi = externalWeatherApi;
    }

    @Override
    public String getWeatherData(String city) throws WeatherServiceException {
        // TODO: Implement logic here
        return externalWeatherApi.fetchWeatherData(city);
    }
}