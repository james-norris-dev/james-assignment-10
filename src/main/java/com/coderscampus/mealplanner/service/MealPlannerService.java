package com.coderscampus.mealplanner.service;

import com.coderscampus.mealplanner.dto.DayResponse;
import com.coderscampus.mealplanner.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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

    public WeekResponse getWeekMeals(String numCalories, String diet, String exclusions) {
        try {
            URI uri = UriComponentsBuilder.fromUriString(baseUrl + "/mealplanner/generate?")
                    .queryParam("timeFrame", "week")
                    .queryParam("targetCalories", numCalories)
                    .queryParam("diet", diet)
                    .queryParam("exclusions", exclusions)
                    .queryParam("apiKey", apiKey)
                    .build()
                    .toUri();

            ResponseEntity<WeekResponse> weekResponse = restTemplate.getForEntity(uri, WeekResponse.class);

            if (!weekResponse.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("Error fetching week meals: " + weekResponse.getStatusCode());
            }

            return weekResponse.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new RuntimeException("API request failed with status code: " + e.getStatusCode());
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching week meals: " + e.getMessage());
        }
    }

    public DayResponse getDayMeals(String numCalories, String diet, String exclusions) {
        try {
            URI uri = UriComponentsBuilder.fromUriString(baseUrl + "/mealplanner/generate?")
                    .queryParam("timeFrame", "day")
                    .queryParam("targetCalories", numCalories)
                    .queryParam("diet", diet)
                    .queryParam("exclusions", exclusions)
                    .queryParam("apiKey", apiKey)
                    .build()
                    .toUri();

            ResponseEntity<DayResponse> dayResponse = restTemplate.getForEntity(uri, DayResponse.class);

            if (!dayResponse.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("Error fetching day meals: " + dayResponse.getStatusCode());
            }

            return dayResponse.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new RuntimeException("API request failed with status code: " + e.getStatusCode());
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching day meals: " + e.getMessage());
        }
    }
}
