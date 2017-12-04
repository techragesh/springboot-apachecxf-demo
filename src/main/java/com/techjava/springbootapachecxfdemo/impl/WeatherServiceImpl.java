package com.techjava.springbootapachecxfdemo.impl;

import com.techjava.springbootapachecxfdemo.helper.WeatherServiceHelper;
import de.codecentric.namespace.weatherservice.WeatherException;
import de.codecentric.namespace.weatherservice.WeatherService;
import de.codecentric.namespace.weatherservice.general.ForecastRequest;
import de.codecentric.namespace.weatherservice.general.ForecastReturn;
import de.codecentric.namespace.weatherservice.general.WeatherInformationReturn;
import de.codecentric.namespace.weatherservice.general.WeatherReturn;
import org.springframework.beans.factory.annotation.Autowired;

public class WeatherServiceImpl implements WeatherService{

    @Autowired
    WeatherServiceHelper weatherServiceHelper;

    @Override
    public WeatherInformationReturn getWeatherInformation(String zip) throws WeatherException {
        return null;
    }

    @Override
    public ForecastReturn getCityForecastByZIP(ForecastRequest forecastRequest) throws WeatherException {
        return weatherServiceHelper.getCityForeCasebyZIP(forecastRequest);
    }

    @Override
    public WeatherReturn getCityWeatherByZIP(ForecastRequest forecastRequest) throws WeatherException {
        return null;
    }
}
