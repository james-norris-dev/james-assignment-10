package com.coderscampus.mealplanner.config;

import com.coderscampus.mealplanner.dto.WeekResponse;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class WeekMealPlannerConfig {

    @Test
    public void callWeekMealPlannerApi() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromUriString("https://api.spoonacular.com/mealplanner/generate?")
                .queryParam("timeFrame", "week")
                .queryParam("targetCalories", "targetCalories")
                .queryParam("diet", "diet")
                .queryParam("exclusions", "exclusions")
                .queryParam("apiKey", "d55e3abbe02c46158da5abd206a63848")
                .build()
                .toUri();

        ResponseEntity<WeekResponse> weekResponse = restTemplate.getForEntity(uri, WeekResponse.class);
        System.out.println(weekResponse.getBody());
    }
}
