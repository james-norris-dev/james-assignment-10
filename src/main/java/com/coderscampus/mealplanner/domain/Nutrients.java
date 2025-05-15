package com.coderscampus.mealplanner.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nutrients {

    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;

    @Override
    public String toString() {
        return "Nutrients{" +
                "calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}
