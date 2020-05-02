
package com.recipeapp.core.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AttributesDTO {

    private List<String> tags;
    private String difficultyLevel;
    private List<String> cuisine;
    private String category;
    private List<String> dishType;
    private List<String> mealTime;

}
