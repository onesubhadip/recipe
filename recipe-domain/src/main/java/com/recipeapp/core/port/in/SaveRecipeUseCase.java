package com.recipeapp.core.port.in;


import com.recipeapp.core.command.SaveRecipeCommand;

public interface SaveRecipeUseCase {

    void saveRecipe(SaveRecipeCommand command);

}
