package com.recipeapp.core.command.handler;


import com.recipe.lib.cqs.CommandResult;
import com.recipeapp.core.command.RecipeCommand;
import com.recipeapp.core.port.out.RecipeRepositorySPI;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveRecipeCommandHandler {
    private RecipeRepositorySPI recipeRepositoryRepository;

    public CommandResult handle(RecipeCommand recipeCommand) {

        return null;
    }
}
