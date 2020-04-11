package com.recipeapp.core.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.List;
import java.util.UUID;

@Data
//@Builder
@NoArgsConstructor
public class Recipe {

    private UUID recipeId;
    private UUID authorId;
    private String name;
    private String shortDescription;
    private String introduction;
    @Singular
    private List<Ingredient> ingredients;
    @Singular
    private List<Steps> steps;
    private Attributes attributes;

}
