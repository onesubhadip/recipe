package com.recipeapp.core.port.out;


import com.recipeapp.core.model.Recipe;

public interface RecipeCommandRepositorySPI {

    void saveRecipe(Recipe recipe);

}
