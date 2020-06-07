package com.recipeapp.app.repository;

import com.recipeapp.core.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipeMongoRepository extends MongoRepository<Recipe, UUID> {
}
