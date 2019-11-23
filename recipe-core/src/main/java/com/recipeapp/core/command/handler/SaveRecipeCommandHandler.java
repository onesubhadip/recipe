package com.recipeapp.core.command.handler;


import com.recipeapp.core.command.RecipeCommand;
import com.recipeapp.core.port.out.RecipeRepositorySPI;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveRecipeCommandHandler implements RecipeCommandHandler<RecipeCommand>{
    private RecipeRepositorySPI recipeRepositoryRepository;

    public void handle(RecipeCommand recipeCommand) {

    }
}
