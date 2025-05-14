package com.coderscampus.mealplanner.dto;

import com.coderscampus.mealplanner.domain.Meal;
import com.coderscampus.mealplanner.domain.Nutrients;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayResponse {
    @JsonProperty("Meals")
    private List<Meal> meals;
    @JsonProperty("Nutrients")
    private Nutrients nutrients;

    @Override
    public String toString() {
        return "DayResponse{" +
                "Meals=" + meals +
                ", Nutrients=" + nutrients +
                '}';
    }
}
