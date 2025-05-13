package com.coderscampus.mealplanner.config;

import com.coderscampus.mealplanner.dto.DayResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class DayMealPlannerConfig {

    public void callDayMealPlannerApi() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromUriString("https://api.spoonacular.com/mealplanner/generate?")
                .queryParam("timeFrame", "day")
                .queryParam("apiKey", "1742768a4d8144a7b03fe2965c571806")
                .build()
                .toUri();

        ResponseEntity<DayResponse> dayResponse = restTemplate.getForEntity(uri, DayResponse.class);
    }
}
