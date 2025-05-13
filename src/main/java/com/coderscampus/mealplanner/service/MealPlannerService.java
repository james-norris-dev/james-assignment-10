package com.coderscampus.mealplanner.service;

import com.coderscampus.mealplanner.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class MealPlannerService {

    private final RestTemplate restTemplate;

    @Autowired
    private MealPlannerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeekResponse getWeekMeals(String numCalories, String diet, String exclusions) {
        URI uri = UriComponentsBuilder.fromUriString("https://api.spoonacular.com/mealplanner/generate?")
                    .queryParam("timeFrame", "week")
                    .queryParam("targetCalories", numCalories)
                    .queryParam("diet", diet    )
                    .queryParam("exclusions", exclusions)
                    .queryParam("apiKey", "d55e3abbe02c46158da5abd206a63848")
                    .build()
                    .toUri();

            ResponseEntity<WeekResponse> weekResponse = restTemplate.getForEntity(uri, WeekResponse.class);
            System.out.println(weekResponse.getBody());
    }
}
