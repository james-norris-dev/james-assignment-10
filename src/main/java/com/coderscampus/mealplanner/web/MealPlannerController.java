package com.coderscampus.mealplanner.web;

import com.coderscampus.mealplanner.dto.DayResponse;
import com.coderscampus.mealplanner.dto.WeekResponse;
import com.coderscampus.mealplanner.service.MealPlannerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<WeekResponse> getWeekMeals(@RequestParam(required = false) String numCalories,
                                                     @RequestParam(required = false) String diet,
                                                     @RequestParam(required = false) String exclusions) {
        try {
            WeekResponse weekResponse = mealPlannerService.getWeekMeals(numCalories, diet, exclusions);
            return ResponseEntity.ok(weekResponse);
        } catch (Exception e) {
            System.err.println("An error occurred while fetching week meals: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new WeekResponse());
        }
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(@RequestParam(required = false) String numCalories,
                                                   @RequestParam(required = false) String diet,
                                                   @RequestParam(required = false) String exclusions) {
        try {
            DayResponse dayResponse = mealPlannerService.getDayMeals(numCalories, diet, exclusions);
            return ResponseEntity.ok(dayResponse);
        } catch (Exception e) {
            System.err.println("An error occurred while fetching day meals: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DayResponse());
        }
    }
}
