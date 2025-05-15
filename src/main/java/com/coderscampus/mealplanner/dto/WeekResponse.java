package com.coderscampus.mealplanner.dto;

import com.coderscampus.mealplanner.domain.Week;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeekResponse {

    private Week week;

    @Override
    public String toString() {
        return "WeekResponse{" +
                "week=" + week +
                '}';
    }
}
