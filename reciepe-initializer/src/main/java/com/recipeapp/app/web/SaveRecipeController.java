package com.recipeapp.app.web;

import com.recipe.lib.utils.CommandResult;
import com.recipe.lib.utils.CommandStatus;
import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.model.dto.RecipeDTO;
import com.recipeapp.core.port.in.SaveRecipeUseCase;
import com.recipeapp.core.utils.RecipeModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class SaveRecipeController {

    @Autowired
    private SaveRecipeUseCase saveRecipeservice;

    @PostMapping(value = "/recipe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommandResult> saveRecipe(@RequestBody RecipeDTO recipeDTO) {

        Recipe recipe = RecipeModelMapper.mapRecipeDtoToDomain(recipeDTO);
        recipe.setId(UUID.randomUUID());
        saveRecipeservice.saveRecipe(SaveRecipeCommand.with(recipe));


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommandResult.builder()
                        .commandId(recipe.getId())
                        .status(CommandStatus.SUCCESS).build());
    }

    @PutMapping(value = "/recipe/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommandResult> saveRecipe(@RequestBody RecipeDTO recipeDTO, @PathVariable String id) {

        Recipe recipe = RecipeModelMapper.mapRecipeDtoToDomain(recipeDTO);
        recipe.setId(UUID.fromString(id));

        saveRecipeservice.saveRecipe(SaveRecipeCommand.with(recipe));


        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(CommandResult.builder()
                        .commandId(recipe.getId())
                        .status(CommandStatus.SUCCESS).build());
    }

}
