package com.coderscampus.mealplanner.web;

import com.coderscampus.mealplanner.dto.DayResponse;
import com.coderscampus.mealplanner.dto.WeekResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class MealPlannerController {

    @GetMapping("mealPlanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(@PathVariable String numCalories, String diet, String exclusions) {
        return null;
    }

    @GetMapping("mealPlanner/day")
    public ResponseEntity<DayResponse> getDayMeals(@PathVariable String numCalories, String diet, String exclusions) {
        return null;
    }
}
