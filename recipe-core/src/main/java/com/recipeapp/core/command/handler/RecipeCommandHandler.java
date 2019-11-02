package com.recipeapp.core.command.handler;


public interface RecipeCommandHandler<RecipeCommand> {
    public void handle(RecipeCommand recipeCommand);
}
