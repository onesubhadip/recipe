package com.recipeapp.core.command.handler;


import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.port.out.RecipeRepositorySPI;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveRecipeCommandHandler {
    private final RecipeRepositorySPI recipeRepositoryRepository;

    public void handle(SaveRecipeCommand recipeCommand) {
        recipeRepositoryRepository.saveRecipe(recipeCommand.getRecipe());
    }
}
