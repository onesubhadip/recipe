package com.recipeapp.app.config;

import com.recipeapp.core.command.handler.SaveRecipeCommandHandler;
import com.recipeapp.core.port.in.SaveRecipeUseCase;
import com.recipeapp.core.port.out.RecipeRepositorySPI;
import com.recipeapp.core.service.SaveRecipeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeConfig {

    @Bean
    public SaveRecipeUseCase createRecipeService(RecipeRepositorySPI recipeRepositorySPI) {

        return new SaveRecipeService(new SaveRecipeCommandHandler(recipeRepositorySPI));
    }
}
