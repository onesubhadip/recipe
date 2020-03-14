package com.recipeapp.core.command.handler;


import com.recipe.lib.cqs.CommandResult;
import com.recipe.lib.cqs.CommandStatus;
import com.recipeapp.core.command.RecipeCommand;
import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.port.out.RecipeRepositorySPI;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveRecipeCommandHandler {
    private final RecipeRepositorySPI recipeRepositoryRepository;

    public CommandResult handle(SaveRecipeCommand recipeCommand) {
        recipeRepositoryRepository.saveRecipe(recipeCommand.getRecipe());
        return CommandResult.builder()
                .commandId(recipeCommand.getRecipe().getRecipeId())
                .commandName(SaveRecipeCommand.class.getSimpleName())
                .status(CommandStatus.SUCCESS)
                .build();
    }
}
