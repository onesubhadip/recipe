package com.recipeapp.query.util;

import com.recipe.lib.utils.Query;
import com.recipe.lib.utils.QueryHandlerFor;
import com.recipeapp.core.query.FindRecipeByIdQuery;

import java.util.Map;
import java.util.UUID;

public class FindByIdQueryGenerator implements QueryGenerator {

    @Override
    public Query generate(Map<String, String[]> requestParameterMap) {
        UUID id = UUID.fromString(requestParameterMap.get("id")[0]);
        return FindRecipeByIdQuery.with(id);
    }
}
