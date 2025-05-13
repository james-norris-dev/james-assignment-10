package com.coderscampus.mealplanner.config;

import com.coderscampus.mealplanner.dto.DayResponse;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class DayMealPlannerConfig {

    @Test
    public void callDayMealPlannerApi() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromUriString("https://api.spoonacular.com/mealplanner/generate?")
                .queryParam("timeFrame", "day")
                .queryParam("targetCalories", "targetCalories")
                .queryParam("diet", "diet")
                .queryParam("exclusions", "exclusions")
                .queryParam("apiKey", "d55e3abbe02c46158da5abd206a63848")
                .build()
                .toUri();

        ResponseEntity<DayResponse> dayResponse = restTemplate.getForEntity(uri, DayResponse.class);
        System.out.println(dayResponse.getBody());
    }
}
