package com.techjava.springbootapachecxfdemo.helper;

import com.techjava.springbootapachecxfdemo.mapper.GetCityForeCasebyZIPOutMapper;
import de.codecentric.namespace.weatherservice.general.ForecastRequest;
import de.codecentric.namespace.weatherservice.general.ForecastReturn;
import org.springframework.stereotype.Component;

@Component
public class WeatherServiceHelper {

    public ForecastReturn getCityForeCasebyZIP(ForecastRequest forecastRequest){
        return GetCityForeCasebyZIPOutMapper.mapGeneralOutlook2Forecast();
    }

}
