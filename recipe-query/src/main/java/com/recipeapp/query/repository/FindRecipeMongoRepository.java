package com.recipeapp.query.repository;

import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.out.RecipeQueryRepositorySPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class FindRecipeMongoRepository implements RecipeQueryRepositorySPI {
    private RecipeQueryMongoRepository recipeQueryMongoRepository;

    @Autowired
    public FindRecipeMongoRepository(RecipeQueryMongoRepository recipeQueryMongoRepository) {
        this.recipeQueryMongoRepository = recipeQueryMongoRepository;
    }

    @Override
    public Optional<Recipe> findRecipeById(UUID id) {
        return recipeQueryMongoRepository.findById(id);
    }
}
