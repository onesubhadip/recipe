package com.recipeapp.core.port.in;

import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.query.Query;

public interface GetRecipeUseCase {
    Recipe getRecipe(Query recipeQuery);
}
