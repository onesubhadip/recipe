package com.recipeapp.core.query.handler;

import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.query.Query;

public interface QueryHandler {
    Recipe handle(final Query getRecipeQuery);
}
