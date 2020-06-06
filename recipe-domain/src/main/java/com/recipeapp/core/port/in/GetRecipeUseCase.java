package com.recipeapp.core.port.in;

import com.recipe.lib.utils.QueryResult;
import com.recipeapp.core.model.Recipe;
import com.recipe.lib.utils.Query;

public interface GetRecipeUseCase {
    QueryResult getRecipe(Query recipeQuery);
}
