package com.recipeapp.core.utils;

import com.recipeapp.core.model.Attributes;
import com.recipeapp.core.model.Ingredient;
import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.model.Steps;
import com.recipeapp.core.model.dto.RecipeDTO;
import com.recipeapp.core.model.dto.StepsDTO;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RecipeModelMapper {

    private RecipeModelMapper(){}
    public static Recipe mapRecipeDtoToDomain(final RecipeDTO recipeDto) {
        return Recipe.builder()
                .authorId(recipeDto.getAuthorId())
                .name(recipeDto.getName())
                .shortDescription(recipeDto.getShortDescription())
                .introduction(recipeDto.getIntroduction())
                .attributes(Attributes.builder()
                        .category(Objects.nonNull(recipeDto.getAttributes()) ? recipeDto.getAttributes().getCategory(): null)
                        .cuisine(recipeDto.getAttributes().getCuisine())
                        .tags(recipeDto.getAttributes().getTags())
                        .dishType(recipeDto.getAttributes().getDishType())
                        .mealTime(recipeDto.getAttributes().getMealTime())
                        .difficultyLevel(recipeDto.getAttributes().getDifficultyLevel())
                        .build())
                .ingredients(recipeDto.getIngredients().stream()
                        .map(ingredientDTO -> Ingredient.builder()
                                .name(ingredientDTO.getName())
                                .description(ingredientDTO.getDescription())
                                .quantity(ingredientDTO.getQuantity())
                                .category(ingredientDTO.getCategory())
                                .build())
                        .collect(Collectors.toList()))
                .steps(mapStepsDtoToDomain(recipeDto.getSteps()))
                .build();
    }
    private static List<Steps> mapStepsDtoToDomain(final List<StepsDTO> stepsDTOList) {
        return Objects.nonNull(stepsDTOList) ? stepsDTOList.stream()
                .map(stepsDTO -> Steps.builder()
                        .heading(stepsDTO.getHeading())
                        .stepSequence(stepsDTO.getStepSequence())
                        .subHeading(stepsDTO.getSubHeading())
                        .description(stepsDTO.getDescription())
                        .estimatedTime(stepsDTO.getEstimatedTime())
                        .images(stepsDTO.getImages())
                        .subSteps(mapStepsDtoToDomain(stepsDTO.getSubSteps()))
                        .build())
                .collect(Collectors.toList())
                : Collections.emptyList();
    }
}
