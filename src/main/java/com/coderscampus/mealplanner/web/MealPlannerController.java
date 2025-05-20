package com.coderscampus.mealplanner.web;

import com.coderscampus.mealplanner.dto.DayResponse;
import com.coderscampus.mealplanner.dto.WeekResponse;
import com.coderscampus.mealplanner.service.MealPlannerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class MealPlannerController {

    private final MealPlannerService mealPlannerService;

    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        WeekResponse weekResponse = mealPlannerService.getWeekMeals(numCalories, diet, exclusions);
        return ResponseEntity.ok(weekResponse);
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        DayResponse dayResponse = mealPlannerService.getDayMeals(numCalories, diet, exclusions);
        return ResponseEntity.ok(dayResponse);
    }
}
