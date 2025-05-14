package com.coderscampus.mealplanner.dto;

import com.coderscampus.mealplanner.domain.Week;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeekResponse {
    @JsonProperty("Week")
    private Week week;

    @Override
    public String toString() {
        return "WeekResponse{" +
                "Week=" + week +
                '}';
    }
}
