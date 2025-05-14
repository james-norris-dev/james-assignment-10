package com.coderscampus.mealplanner.domain;

import com.coderscampus.mealplanner.dto.DayResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Week {
    @JsonProperty("Monday")
    private DayResponse monday;
    @JsonProperty("Tuesday")
    private DayResponse tuesday;
    @JsonProperty("Wednesday")
    private DayResponse wednesday;
    @JsonProperty("Thursday")
    private DayResponse thursday;
    @JsonProperty("Friday")
    private DayResponse friday;
    @JsonProperty("Saturday")
    private DayResponse saturday;
    @JsonProperty("Sunday")
    private DayResponse sunday;

    @Override
    public String toString() {
        return "Week{" +
                "Monday=" + monday +
                ", Tuesday=" + tuesday +
                ", Wednesday=" + wednesday +
                ", Thursday=" + thursday +
                ", Friday=" + friday +
                ", Saturday=" + saturday +
                ", Sunday=" + sunday +
                '}';
    }
}
