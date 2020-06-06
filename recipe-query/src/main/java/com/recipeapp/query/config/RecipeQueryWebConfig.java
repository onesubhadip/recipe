package com.recipeapp.query.config;

import com.recipe.lib.utils.NamedQuery;
import com.recipe.lib.utils.Query;
import com.recipe.lib.utils.QueryHandler;
import com.recipe.lib.utils.QueryHandlerFor;
import com.recipeapp.core.port.out.RecipeQueryRepositorySPI;
import com.recipeapp.core.query.handler.FindRecipeByIdQueryHandler;
import com.recipeapp.query.util.QueryGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RecipeQueryWebConfig {

    @Bean
    public FindRecipeByIdQueryHandler findRecipeByIdQueryHandler(RecipeQueryRepositorySPI recipeRepositorySPI) {
        return new FindRecipeByIdQueryHandler(recipeRepositorySPI);
    }

    @Bean
    public Map<String, QueryHandler> queryHandlerMap(ApplicationContext context) {
        Map<String, QueryHandler> queryHandlerMap = new HashMap<>();
        Map<String, QueryHandler> beansOfType = context.getBeansOfType(QueryHandler.class);

        beansOfType.values().forEach(handler -> {
            Class<? extends Query>[] queryInQuestion = handler.getClass().getAnnotation(QueryHandlerFor.class).value();
            Arrays.stream(queryInQuestion).forEach(q -> {
                String queryName = q.getAnnotation(NamedQuery.class).value().toString();
                queryHandlerMap.put(queryName, handler);
            });
        });
        return queryHandlerMap;
    }

    @Bean
    public Map<String, QueryGenerator> queryGeneratorMap() {
        return null;
    }
}
