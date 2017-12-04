package com.techjava.springbootapachecxfdemo;

import com.techjava.springbootapachecxfdemo.config.ClientTestConfig;
import com.techjava.springbootapachecxfdemo.request.ForeCastRequestByZip;
import de.codecentric.namespace.weatherservice.WeatherException;
import de.codecentric.namespace.weatherservice.WeatherService;
import de.codecentric.namespace.weatherservice.general.ForecastRequest;
import de.codecentric.namespace.weatherservice.general.ForecastReturn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ClientTestConfig.class)
public class WeatherServiceTest {

    @Autowired
    private WeatherService weatherServiceTestClient;

    @Test
    public void getCityForecastByZIP() throws WeatherException {
        ForecastRequest forecastRequest = ForeCastRequestByZip.generateDummyRequest();
        ForecastReturn forecastReturn = weatherServiceTestClient.getCityForecastByZIP(forecastRequest);
        System.out.println("Success-- >" +forecastReturn.isSuccess());
        System.out.println("City-- >" +forecastReturn.getCity());
        assertNotNull(forecastReturn);
        assertEquals(true, forecastReturn.isSuccess());
        assertEquals("DenHaag", forecastReturn.getCity());
        assertEquals("22%", forecastReturn.getForecastResult().getForecast().get(0).getProbabilityOfPrecipiation().getDaytime());
    }
}
