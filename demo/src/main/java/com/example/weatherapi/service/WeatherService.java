package com.example.weatherapi.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherService {


/*
    RestTemplate restTemplate;
    public final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public String getWeatherForecast() {
       // String url="https://tapi.wetter.com/v2.3/rapidapi/forecast/"+cityLoc+"/summary/";
        String url="http://ip.jsontest.com/";
        System.out.println(url);
        HttpHeaders headers = getHttpHeaders();
        HttpEntity<String> entity=new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        logger.info("okkkkkkkkkkkkk", response);
       // ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
        return "Sucess";
    }
    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("X-Application-ID","com.wetter/ios v1.0");
        headers.set("Host", "");
        return headers;
    }*/

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
