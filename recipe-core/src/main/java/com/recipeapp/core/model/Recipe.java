package com.recipeapp.core.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Recipe {

    private UUID recipeId;
    private UUID authorId;
    private String name;
    private String shortDescription;
    private String introduction;
    private List<Ingredient> ingredients;
    private List<Steps> steps;
    private Attributes attributes;

}
