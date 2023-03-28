package com.example.weatherapi.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherService {
    

    public String RapidApiGetForecastSummaryByLocationName(String location) {
        String url = "https://tapi.wetter.com/v2.3/rapidapi/forecast/"+location+"/summary/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Application-ID", "com.wetter/ios v1.0");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }



    public String RapidApiGetHourlyForecastByLocationName(String location) {
        String url= "https://tapi.wetter.com/v2.3/rapidapi/forecast/"+location+"/hourly/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Application-ID", "com.wetter/ios v1.0");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}
