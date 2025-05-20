package com.coderscampus.mealplanner.service;

import com.coderscampus.mealplanner.dto.DayResponse;
import com.coderscampus.mealplanner.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class MealPlannerService {

    private final WebClient webClient;
    private final String apiKey;

    public MealPlannerService(@Value("${spoonacular.api.base-url}") String baseUrl,
                              @Value("${spoonacular.api.key}") String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
        this.apiKey = apiKey;
    }

    public <T> T getMeals(String timeFrame, String numCalories, String diet, String exclusions, Class<T> responseType) {
        try {
            return webClient.get().uri(uriBuilder -> uriBuilder
                            .path("/mealplanner/generate")
                            .queryParam("timeFrame", timeFrame)
                            .queryParamIfPresent("targetCalories", Optional.ofNullable(numCalories))
                            .queryParamIfPresent("diet", Optional.ofNullable(diet))
                            .queryParamIfPresent("exclusions", Optional.ofNullable(exclusions))
                            .queryParam("apiKey", apiKey)
                            .build())
                    .retrieve()
                    .bodyToMono(responseType)
                    .block();

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch meals for " + timeFrame + ": " + e.getMessage());
        }
    }

    public DayResponse getDayMeals(String numCalories, String diet, String exclusions) {
        return getMeals("day", numCalories, diet, exclusions, DayResponse.class);
    }

    public WeekResponse getWeekMeals(String numCalories, String diet, String exclusions) {
        return getMeals("week", numCalories, diet, exclusions, WeekResponse.class);
    }
}
