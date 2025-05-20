package com.coderscampus.mealplanner.service;

import com.coderscampus.mealplanner.dto.DayResponse;
import com.coderscampus.mealplanner.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class MealPlannerService {

    @Value("${spoonacular.api.base-url}")
    private String baseUrl;

    @Value("${spoonacular.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    @Autowired
    public MealPlannerService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public <T> T getMeals(String timeFrame, String numCalories, String diet, String exclusions, Class<T> responseType) {
        try {
            URI uri = UriComponentsBuilder.fromUriString(baseUrl + "/mealplanner/generate?")
                    .queryParam("timeFrame", timeFrame)
                    .queryParamIfPresent("targetCalories", Optional.ofNullable(numCalories))
                    .queryParamIfPresent("diet", Optional.ofNullable(diet))
                    .queryParamIfPresent("exclusions", Optional.ofNullable(exclusions))
                    .queryParam("apiKey", apiKey)
                    .build()
                    .toUri();
            ResponseEntity<T> response = restTemplate.getForEntity(uri, responseType);

            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("Error fetching meals: " + response.getStatusCode());
            }

            return response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new RuntimeException("API request failed with status code: " + e.getStatusCode());
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching meals: " + e.getMessage());
        }
    }

    public DayResponse getDayMeals(String numCalories, String diet, String exclusions) {
        return getMeals("day", numCalories, diet, exclusions, DayResponse.class);
    }

    public WeekResponse getWeekMeals(String numCalories, String diet, String exclusions) {
        return getMeals("week", numCalories, diet, exclusions, WeekResponse.class);
    }
}
