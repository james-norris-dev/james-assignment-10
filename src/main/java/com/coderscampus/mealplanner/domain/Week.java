package com.coderscampus.mealplanner.domain;

import com.coderscampus.mealplanner.dto.DayResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Week {

    private DayResponse monday;
    private DayResponse tuesday;
    private DayResponse wednesday;
    private DayResponse thursday;
    private DayResponse friday;
    private DayResponse saturday;
    private DayResponse sunday;

    @Override
    public String toString() {
        return "Week{" +
                "monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                ", saturday=" + saturday +
                ", sunday=" + sunday +
                '}';
    }
}
