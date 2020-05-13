package com.recipeapp.core.command.handler;


import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.port.out.RecipeCommandRepositorySPI;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveRecipeCommandHandler {
    private final RecipeCommandRepositorySPI recipeRepositoryRepository;

    public void handle(SaveRecipeCommand recipeCommand) {
        recipeRepositoryRepository.saveRecipe(recipeCommand.getRecipe());
    }
}
