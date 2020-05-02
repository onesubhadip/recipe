package com.recipeapp.core.service;


import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.command.handler.SaveRecipeCommandHandler;
import com.recipeapp.core.model.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SaveRecipeServiceTest {
    @Mock
    private SaveRecipeCommandHandler recipeCommandHandler;

    private SaveRecipeService saveRecipeService;

    @BeforeEach
    public void init() {
        saveRecipeService = new SaveRecipeService(recipeCommandHandler);
    }

    @Test
    public void whenSaveRecipeSuccess_ShouldCallCommandHandler() {
        SaveRecipeCommand saveRecipeCommand = SaveRecipeCommand.with(Mockito.mock(Recipe.class));

        willDoNothing().given(recipeCommandHandler).handle(saveRecipeCommand);

        saveRecipeService.saveRecipe(saveRecipeCommand);

        verify(recipeCommandHandler).handle(saveRecipeCommand);

    }
}
