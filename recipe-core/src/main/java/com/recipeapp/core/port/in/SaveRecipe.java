package com.recipeapp.core.port.in;


import com.recipeapp.core.command.SaveRecipeCommand;

public interface SaveRecipe {
    public void save(SaveRecipeCommand recipeCommand);
}
