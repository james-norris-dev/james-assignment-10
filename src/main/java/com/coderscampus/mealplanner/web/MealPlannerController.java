package com.coderscampus.mealplanner.web;

import com.coderscampus.mealplanner.dto.DayResponse;
import com.coderscampus.mealplanner.dto.WeekResponse;
import com.coderscampus.mealplanner.service.MealPlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MealPlannerController {

    private final MealPlannerService mealPlannerService;

    @Autowired
    public MealPlannerController(MealPlannerService mealPlannerService) {
        this.mealPlannerService = mealPlannerService;
    }

    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(@RequestParam String numCalories,
                                                     @RequestParam String diet,
                                                     @RequestParam String exclusions) {
        WeekResponse weekResponse = mealPlannerService.getWeekMeals(numCalories, diet, exclusions);
        return ResponseEntity.ok(weekResponse);
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(@RequestParam String numCalories,
                                                     @RequestParam String diet,
                                                     @RequestParam String exclusions) {
        DayResponse dayResponse = mealPlannerService.getDayMeals(numCalories, diet, exclusions);
        return ResponseEntity.ok(dayResponse);
    }
}
