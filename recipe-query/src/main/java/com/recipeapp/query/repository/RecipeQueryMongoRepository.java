package com.recipeapp.query.repository;

import com.recipeapp.core.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipeQueryMongoRepository extends MongoRepository<Recipe, UUID> {
}
