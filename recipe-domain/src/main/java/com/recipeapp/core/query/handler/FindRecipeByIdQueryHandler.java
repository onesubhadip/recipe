package com.recipeapp.core.query.handler;

import com.recipe.lib.utils.Query;
import com.recipe.lib.utils.QueryHandler;
import com.recipe.lib.utils.QueryHandlerFor;
import com.recipe.lib.utils.QueryResult;
import com.recipeapp.core.port.in.GetRecipeUseCase;
import com.recipeapp.core.port.out.RecipeQueryRepositorySPI;
import com.recipeapp.core.query.FindByIdResult;
import com.recipeapp.core.query.FindRecipeByIdQuery;
import lombok.RequiredArgsConstructor;

@QueryHandlerFor({FindRecipeByIdQuery.class})
@RequiredArgsConstructor
public class FindRecipeByIdQueryHandler implements QueryHandler, GetRecipeUseCase {

    private final RecipeQueryRepositorySPI recipeQueryRepository;

    @Override
    public QueryResult handle(Query getRecipeQuery) {

        return recipeQueryRepository.findRecipeById(((FindRecipeByIdQuery) getRecipeQuery).getId())
                .map(FindByIdResult::with)
                .orElseGet(FindByIdResult::none);
    }

    @Override
    public QueryResult getRecipe(Query recipeQuery) {
        return this.handle(recipeQuery);
    }
}
