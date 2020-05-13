package com.recipeapp.query.config;

import com.recipeapp.core.port.in.GetRecipeUseCase;
import com.recipeapp.core.port.out.RecipeQueryRepositorySPI;
import com.recipeapp.core.query.QueryName;
import com.recipeapp.core.query.handler.FindRecipeByIdQueryHandler;
import com.recipeapp.core.query.handler.QueryHandler;
import com.recipeapp.core.service.GetRecipeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RecipeQueryWebConfig {

    @Bean
    public GetRecipeUseCase createGetRecipeUseCaseBean(RecipeQueryRepositorySPI recipeRepositorySPI) {
        QueryHandler recipeByIdHandler = new FindRecipeByIdQueryHandler(recipeRepositorySPI);
        Map<String, QueryHandler> queryHandlerMap = new HashMap<>();
        queryHandlerMap.put(QueryName.findById.name(), recipeByIdHandler);

        return new GetRecipeService(queryHandlerMap);
    }
}
