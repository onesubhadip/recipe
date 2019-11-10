
package com.recipeapp.core.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Attributes {

    private List<String> tags;
    private String difficultyLevel;
    private List<String> cuisine;
    private String category;
    private List<String> dishType;
    private List<String> mealTime;

}
