package com.coderscampus.mealplanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Nutrients {
    @JsonProperty("calories")
    private double calories;
    @JsonProperty("protein")
    private double protein;
    @JsonProperty("fat")
    private double fat;
    @JsonProperty("carbohydrates")
    private double carbohydrates;
}
