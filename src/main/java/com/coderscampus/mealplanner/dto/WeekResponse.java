package com.coderscampus.mealplanner.dto;

import com.coderscampus.mealplanner.domain.Week;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WeekResponse {
    @JsonProperty("week")
    private Week week;
}
