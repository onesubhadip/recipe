package com.recipeapp.core.service;

import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.in.GetRecipeUseCase;
import com.recipeapp.core.query.Query;
import com.recipeapp.core.query.handler.QueryHandler;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class GetRecipeService implements GetRecipeUseCase {

    private final Map<String, QueryHandler> queryHandlerMapping;

    @Override
    public Recipe getRecipe(Query recipeQuery) {
        return queryHandlerMapping.get(recipeQuery.getName().name()).handle(recipeQuery);
    }



}
