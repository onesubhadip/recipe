package com.recipeapp.core.command.handler;


import com.recipeapp.core.command.RecipeCommand;
import com.recipeapp.core.port.out.StoreRecipe;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveRecipeCommandHandler implements RecipeCommandHandler<RecipeCommand>{
    private StoreRecipe storeRecipeRepository;

    public void handle(RecipeCommand recipeCommand) {

    }
}
