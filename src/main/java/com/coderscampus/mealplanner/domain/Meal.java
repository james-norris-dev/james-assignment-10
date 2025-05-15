package com.coderscampus.mealplanner.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    private Long id;
    private String image;
    private String imageType;
    private int readyInMinutes;
    private int servings;
    private String sourceUrl;

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", imageType='" + imageType + '\'' +
                ", readyInMinutes=" + readyInMinutes +
                ", servings=" + servings +
                ", sourceUrl='" + sourceUrl + '\'' +
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
