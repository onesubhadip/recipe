package com.recipeapp.core.command;

import com.recipe.lib.utils.Command;
import com.recipeapp.core.model.Recipe;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "with")
public class SaveRecipeCommand implements Command {
    private final Recipe recipe;
}
