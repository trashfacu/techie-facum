package com.techie.services;

import com.techie.exceptions.WeatherServiceException;

public interface WeatherService {

    String getWeatherData(String city) throws WeatherServiceException;
}

