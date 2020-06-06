package com.recipeapp.query.util;

import com.recipe.lib.utils.Query;

import java.util.Map;

public interface QueryGenerator {
    Query generate(Map<String, String[]> requestParameterMap);
}
