package com.recipeapp.query.config;

import com.recipe.lib.utils.NamedQuery;
import com.recipe.lib.utils.Query;
import com.recipe.lib.utils.QueryHandler;
import com.recipe.lib.utils.ForQuery;
import com.recipeapp.core.port.out.RecipeQueryRepositorySPI;
import com.recipeapp.core.query.handler.FindRecipeByIdQueryHandler;
import com.recipeapp.query.util.QueryGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class RecipeQueryWebConfig {

    @Bean
    public FindRecipeByIdQueryHandler findRecipeByIdQueryHandler(RecipeQueryRepositorySPI recipeRepositorySPI) {
        return new FindRecipeByIdQueryHandler(recipeRepositorySPI);
    }

    @Bean
    public Map<String, QueryHandler> queryHandlerMap(ApplicationContext context) {
        Map<String, QueryHandler> beansOfType = context.getBeansOfType(QueryHandler.class);

        return beansOfType.values().stream()
                .map(queryGenerator -> {
                    Map<String, QueryHandler> queryHandlerMap = new HashMap<>();
                    Class<? extends Query>[] queryArray = queryGenerator.getClass().getAnnotation(ForQuery.class).value();
                    Arrays.stream(queryArray).forEach(q -> {
                        String queryName = q.getAnnotation(NamedQuery.class).value().toString();
                        queryHandlerMap.put(queryName, queryGenerator);
                    });
                    return queryHandlerMap.entrySet();
                })
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Bean
    public Map<String, QueryGenerator> queryGeneratorMap(ApplicationContext context) {
        Map<String, QueryGenerator> beansOfType = context.getBeansOfType(QueryGenerator.class);


        return beansOfType.values().stream()
                .map(queryGenerator -> {
                    Map<String, QueryGenerator> queryGeneratorMap = new HashMap<>();
                    Class<? extends Query>[] queryArray = queryGenerator.getClass().getAnnotation(ForQuery.class).value();
                    Arrays.stream(queryArray).forEach(q -> {
                        String queryName = q.getAnnotation(NamedQuery.class).value().toString();
                        queryGeneratorMap.put(queryName, queryGenerator);
                    });
                    return queryGeneratorMap.entrySet();
                })
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
