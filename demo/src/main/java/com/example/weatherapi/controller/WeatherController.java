package com.example.weatherapi.controller;

import com.example.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {
@Autowired
WeatherService resp;

    @GetMapping("/summary/{location}")
    public String RapidApiGetForecastSummaryByLocationName(@PathVariable String location) {
        return resp.RapidApiGetForecastSummaryByLocationName(location);
    }

    @GetMapping("/gethour/{location}")
    public String RapidApiGetHourlyForecastByLocationName(@PathVariable String location) {
        return resp.RapidApiGetHourlyForecastByLocationName(location);
    }



}
