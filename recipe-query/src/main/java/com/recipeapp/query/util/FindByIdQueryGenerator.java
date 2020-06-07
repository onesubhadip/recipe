package com.recipeapp.query.util;

import com.recipe.lib.utils.Query;
import com.recipe.lib.utils.ForQuery;
import com.recipeapp.core.query.FindRecipeByIdQuery;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@ForQuery({FindRecipeByIdQuery.class})
@Service
public class FindByIdQueryGenerator implements QueryGenerator {

    @Override
    public Query generate(Map<String, String[]> requestParameterMap) {
        UUID id = UUID.fromString(requestParameterMap.get("id")[0]);
        return FindRecipeByIdQuery.with(id);
    }
}
