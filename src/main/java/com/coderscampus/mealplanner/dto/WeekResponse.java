package com.coderscampus.mealplanner.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeekResponse {

    private Map<String, DayResponse> week;

    @Override
    public String toString() {
        return "WeekResponse{" +
                "week=" + week +
                '}';
    }
}
