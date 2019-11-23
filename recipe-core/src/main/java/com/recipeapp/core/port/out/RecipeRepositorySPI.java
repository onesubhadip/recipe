package com.recipeapp.core.port.out;


import com.recipeapp.core.model.Recipe;

import java.util.function.Consumer;

public interface RecipeRepositorySPI extends Consumer<Recipe> {

    void saveRecipe(Recipe recipe);

}
