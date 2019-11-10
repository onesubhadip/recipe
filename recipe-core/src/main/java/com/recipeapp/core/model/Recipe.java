package com.recipeapp.core.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Recipe {

    private String recipeId;
    private String authorId;
    private String name;
    private String shortDescription;
    private String introduction;
    private List<Ingredient> ingredients;
    private List<Steps> steps;
    private Attributes attributes;

}
