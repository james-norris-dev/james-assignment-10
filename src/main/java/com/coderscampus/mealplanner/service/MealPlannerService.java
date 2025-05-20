package com.coderscampus.mealplanner.service;

import com.coderscampus.mealplanner.dto.DayResponse;
import com.coderscampus.mealplanner.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class MealPlannerService {

    private final String baseUrl;
    private final String apiKey;
    private final RestTemplate restTemplate;

    public MealPlannerService(@Value("${spoonacular.api.base-url}") String baseUrl,
                              @Value("${spoonacular.api.key}") String apiKey,
                              RestTemplateBuilder builder) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.restTemplate = builder.build();
    }

    public DayResponse getDayMeals(String numCalories, String diet, String exclusions) {
        return getMeals("day", numCalories, diet, exclusions, DayResponse.class);
    }

    public WeekResponse getWeekMeals(String numCalories, String diet, String exclusions) {
        return getMeals("week", numCalories, diet, exclusions, WeekResponse.class);
    }

    private <T> T getMeals(String timeFrame, String numCalories, String diet, String exclusions,
                           Class<T> responseType) {
        try {
            URI uri = getUri(timeFrame, numCalories, diet, exclusions);
            ResponseEntity<T> response = restTemplate.getForEntity(uri, responseType);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching meals: " + e.getMessage() + "with apiKey: " + apiKey);
        }
    }

    private URI getUri(String timeFrame, String numCalories, String diet, String exclusions) {
        return UriComponentsBuilder.fromUriString(baseUrl + "/mealplanner/generate?")
                .queryParam("timeFrame", timeFrame)
                .queryParamIfPresent("targetCalories", Optional.ofNullable(numCalories))
                .queryParamIfPresent("diet", Optional.ofNullable(diet))
                .queryParamIfPresent("exclusions", Optional.ofNullable(exclusions))
                .queryParam("apiKey", apiKey)
                .build()
                .toUri();
    }
}
