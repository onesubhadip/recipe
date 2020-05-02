package com.recipeapp.core.service;


import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.command.handler.SaveRecipeCommandHandler;
import com.recipeapp.core.port.in.SaveRecipeUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveRecipeService implements SaveRecipeUseCase {

    private SaveRecipeCommandHandler saveRecipeCommandHandler;

    @Override
    public void saveRecipe(SaveRecipeCommand command) {
        saveRecipeCommandHandler.handle(command);
    }
}
