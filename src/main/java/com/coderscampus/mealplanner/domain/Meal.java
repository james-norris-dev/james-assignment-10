package com.coderscampus.mealplanner.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Meal {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("Image")
    private String image;
    @JsonProperty("Image Type")
    private String imageType;
    @JsonProperty("Ready In Minutes")
    private int readyInMinutes;
    @JsonProperty("Servings")
    private int servings;
    @JsonProperty("Source Url")
    private String sourceUrl;

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", Image='" + image + '\'' +
                ", Image Type='" + imageType + '\'' +
                ", Ready In Minutes=" + readyInMinutes +
                ", Servings=" + servings +
                ", Source Url='" + sourceUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(id, meal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
