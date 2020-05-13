package com.recipeapp.core.query.handler;

import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.out.RecipeQueryRepositorySPI;
import com.recipeapp.core.query.FindRecipeByIdQuery;
import com.recipeapp.core.query.Query;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindRecipeByIdQueryHandler implements QueryHandler{

    private final RecipeQueryRepositorySPI recipeQueryRepository;

    @Override
    public Recipe handle(Query getRecipeQuery) {
        return recipeQueryRepository.findRecipeById(((FindRecipeByIdQuery) getRecipeQuery).getId())
                .orElseGet(() -> Recipe.builder().build());
    }
}
