package com.coderscampus.mealplanner.dto;

import com.coderscampus.mealplanner.domain.Week;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WeekResponse {
    @JsonProperty("week")
    private String week;
}
