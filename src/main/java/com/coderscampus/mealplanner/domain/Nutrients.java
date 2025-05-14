package com.coderscampus.mealplanner.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nutrients {
    @JsonProperty("Calories")
    private double calories;
    @JsonProperty("Protein")
    private double protein;
    @JsonProperty("Fat")
    private double fat;
    @JsonProperty("Carbohydrates")
    private double carbohydrates;

    @Override
    public String toString() {
        return "Nutrients{" +
                "Calories=" + calories +
                ", Protein=" + protein +
                ", Fat=" + fat +
                ", Carbohydrates=" + carbohydrates +
                '}';
    }
}
