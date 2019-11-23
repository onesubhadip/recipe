package com.recipeapp.core.service;


import com.recipe.lib.cqs.CommandResult;
import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.command.handler.SaveRecipeCommandHandler;
import com.recipeapp.core.port.in.CreateRecipeUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateRecipeService implements CreateRecipeUseCase {

    private SaveRecipeCommandHandler saveRecipeCommandHandler;

    @Override
    public CommandResult createNewRecipe(SaveRecipeCommand command) {
        return saveRecipeCommandHandler.handle(command);
    }
}
