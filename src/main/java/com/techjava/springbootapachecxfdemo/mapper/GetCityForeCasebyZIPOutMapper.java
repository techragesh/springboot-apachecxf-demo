package com.techjava.springbootapachecxfdemo.mapper;

import de.codecentric.namespace.weatherservice.datatypes.ArrayOfForecast;
import de.codecentric.namespace.weatherservice.datatypes.Forecast;
import de.codecentric.namespace.weatherservice.datatypes.POP;
import de.codecentric.namespace.weatherservice.datatypes.Temp;
import de.codecentric.namespace.weatherservice.general.ForecastReturn;
import de.codecentric.namespace.weatherservice.general.ObjectFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

public final class GetCityForeCasebyZIPOutMapper {

    private static ObjectFactory objectFactoryGeneral = new ObjectFactory();
    private static de.codecentric.namespace.weatherservice.datatypes.ObjectFactory objectFactoryDatatypes = new de.codecentric.namespace.weatherservice.datatypes.ObjectFactory();

    public static ForecastReturn mapGeneralOutlook2Forecast(){
        ForecastReturn forecastReturn = objectFactoryGeneral.createForecastReturn();
        forecastReturn.setCity("DenHaag");
        forecastReturn.setState("Amsterdam");
        forecastReturn.setSuccess(true);
        forecastReturn.setWeatherStationCity("DenHaag");
        forecastReturn.setForecastResult(generateForecastResult(forecastReturn.getCity()));
        return forecastReturn;
    }

    private static ArrayOfForecast generateForecastResult(String city) {
        ArrayOfForecast forecastContainer = objectFactoryDatatypes.createArrayOfForecast();
        forecastContainer.getForecast().add(generateForecast(city));
        return forecastContainer;
    }


    private static Forecast generateForecast(String city) {
        Forecast forecast = objectFactoryDatatypes.createForecast();
        forecast.setDate(generateCalendarFromNow());
        forecast.setDesciption("Vorhersage für " + city);
        forecast.setTemperatures(generateTemp());
        forecast.setProbabilityOfPrecipiation(generateRegenwahrscheinlichkeit());
        return forecast;
    }


    private static POP generateRegenwahrscheinlichkeit() {
        POP pop = objectFactoryDatatypes.createPOP();
        pop.setDaytime("22%");
        pop.setNighttime("5000%");
        return pop;
    }


    private static Temp generateTemp() {
        Temp temp = objectFactoryDatatypes.createTemp();
        temp.setDaytimeHigh("90°");
        temp.setMorningLow("0°");
        return temp;
    }


    private static XMLGregorianCalendar generateCalendarFromNow() {
        GregorianCalendar gregCal = GregorianCalendar.from(ZonedDateTime.now());
        XMLGregorianCalendar xmlGregCal = null;
        try {
            xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregCal);
        } catch (DatatypeConfigurationException exception) {
            //LOG.calenderMappingNotWorking(exception);
        }
        return xmlGregCal;
    }
}
