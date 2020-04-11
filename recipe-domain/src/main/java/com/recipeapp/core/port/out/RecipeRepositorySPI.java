package com.recipeapp.core.port.out;


import com.recipeapp.core.model.Recipe;

public interface RecipeRepositorySPI {

    void saveRecipe(Recipe recipe);

}
