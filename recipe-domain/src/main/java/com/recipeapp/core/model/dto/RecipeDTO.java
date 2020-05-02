package com.recipeapp.core.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class RecipeDTO {

    private UUID authorId;
    private String name;
    private String shortDescription;
    private String introduction;
    private List<IngredientDTO> ingredients;
    private List<StepsDTO> steps;
    private AttributesDTO attributes;
}
