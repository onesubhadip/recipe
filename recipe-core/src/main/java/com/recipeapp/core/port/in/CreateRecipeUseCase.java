package com.recipeapp.core.port.in;


import com.recipe.lib.cqs.CommandResult;
import com.recipeapp.core.command.SaveRecipeCommand;

public interface CreateRecipeUseCase {

    CommandResult createNewRecipe(SaveRecipeCommand command);

}
