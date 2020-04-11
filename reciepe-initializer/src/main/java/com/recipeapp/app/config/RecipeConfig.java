package com.recipeapp.app.config;

import com.recipeapp.core.command.handler.SaveRecipeCommandHandler;
import com.recipeapp.core.port.in.CreateRecipeUseCase;
import com.recipeapp.core.port.out.RecipeRepositorySPI;
import com.recipeapp.core.service.CreateRecipeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeConfig {

    @Bean
    public CreateRecipeUseCase createRecipeService(RecipeRepositorySPI recipeRepositorySPI) {

        return new CreateRecipeService(new SaveRecipeCommandHandler(recipeRepositorySPI));
    }
}
