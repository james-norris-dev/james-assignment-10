package com.coderscampus.mealplanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DayResponse {
    @JsonProperty("meals")
    private List<Meal> meals;
    @JsonProperty("nutrients")
    private Nutrients nutrients;
}
