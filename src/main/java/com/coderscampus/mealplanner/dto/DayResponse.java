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

    private List<Meal> meals;
    private Nutrients nutrients;

    @Override
    public String toString() {
        return "DayResponse{" +
                "meals=" + meals +
                ", nutrients=" + nutrients +
                '}';
    }
}
