package com.recipeapp.core.service;

import com.recipe.lib.utils.Query;
import com.recipe.lib.utils.QueryHandler;
import com.recipe.lib.utils.QueryResult;
import com.recipeapp.core.port.in.GetRecipeUseCase;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class GetRecipeService implements GetRecipeUseCase {

    private final Map<String, QueryHandler> queryHandlerMapping;

    @Override
    public QueryResult getRecipe(Query recipeQuery) {
        return queryHandlerMapping.get(recipeQuery.name().name()).handle(recipeQuery);
    }
}