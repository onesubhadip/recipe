package com.recipeapp.core.port.out;

import com.recipeapp.core.model.Recipe;

import java.util.Optional;
import java.util.UUID;

public interface RecipeQueryRepositorySPI {
    Optional<Recipe> findRecipeById(UUID id);
}
