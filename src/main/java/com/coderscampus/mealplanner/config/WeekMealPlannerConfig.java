package com.coderscampus.mealplanner.config;

import com.coderscampus.mealplanner.dto.WeekResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class WeekMealPlannerConfig {

        public void callWeekMealPlannerApi() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromUriString("https://api.spoonacular.com/mealplanner/generate?")
                .queryParam("timeFrame", "week")
                .build()
                .toUri();

        ResponseEntity<WeekResponse> weekResponse = restTemplate.getForEntity(uri, WeekResponse.class);
    }
}
