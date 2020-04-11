package com.recipeapp.app.web;

import com.recipe.lib.cqs.CommandResult;
import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.in.CreateRecipeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateRecipeController {

    @Autowired
    private CreateRecipeUseCase createRecipeService;

    @PostMapping(value = "/recipe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommandResult> saveRecipe(@RequestBody Recipe recipe) {

        //TODO generate ID from backend
        CommandResult saveRecipeResult = createRecipeService.createNewRecipe(SaveRecipeCommand.with(recipe));

        return ResponseEntity.status(HttpStatus.CREATED).body(saveRecipeResult);
    }


}
