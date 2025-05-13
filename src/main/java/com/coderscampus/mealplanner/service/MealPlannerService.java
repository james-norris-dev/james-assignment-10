package com.coderscampus.mealplanner.service;

import com.coderscampus.mealplanner.dto.DayResponse;
import com.coderscampus.mealplanner.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class MealPlannerService {

    @Value("${mealplanner.api.base-url}")
    private String baseUrl;

    @Value("${mealplanner.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    @Autowired
    public MealPlannerService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public WeekResponse getWeekMeals(String numCalories, String diet, String exclusions) {
        URI uri = UriComponentsBuilder.fromUriString(baseUrl + "/mealplanner/generate?")
                    .queryParam("timeFrame", "week")
                    .queryParam("targetCalories", numCalories)
                    .queryParam("diet", diet    )
                    .queryParam("exclusions", exclusions)
                    .queryParam("apiKey", apiKey)
                    .build()
                    .toUri();

        ResponseEntity<WeekResponse> weekResponse = restTemplate.getForEntity(uri, WeekResponse.class);
        return weekResponse.getBody();
    }

        public DayResponse getDayMeals(String numCalories, String diet, String exclusions) {
        URI uri = UriComponentsBuilder.fromUriString(baseUrl + "/mealplanner/generate?")
                    .queryParam("timeFrame", "day")
                    .queryParam("targetCalories", numCalories)
                    .queryParam("diet", diet    )
                    .queryParam("exclusions", exclusions)
                    .queryParam("apiKey", apiKey)
                    .build()
                    .toUri();

        ResponseEntity<DayResponse> dayResponse = restTemplate.getForEntity(uri, DayResponse.class);
        return dayResponse.getBody();
    }
}
