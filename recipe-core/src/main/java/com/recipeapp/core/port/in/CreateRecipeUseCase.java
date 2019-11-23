package com.recipeapp.core.port.in;

import com.recipeapp.core.command.SaveRecipeCommand;

public interface CreateRecipeUseCase {

    void createNewRecipe(SaveRecipeCommand command);

}
