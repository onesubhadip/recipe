package com.recipeapp.core.command.handler;

import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.out.RecipeCommandRepositorySPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SaveRecipeCommandHandlerTest {
    private SaveRecipeCommandHandler saveRecipeCommandHandler;

    @Mock
    private RecipeCommandRepositorySPI recipeRepository;

    @BeforeEach
    public void init() {
        saveRecipeCommandHandler = new SaveRecipeCommandHandler(recipeRepository);
    }

    @Test
    public void saveRecipeShouldPersistRecipeWithRecipeRepository() {
        willDoNothing().given(recipeRepository).saveRecipe(any(Recipe.class));
        Recipe recipe = Recipe.builder().build();
        SaveRecipeCommand saveRecipeCommand = SaveRecipeCommand.with(recipe);
        saveRecipeCommandHandler.handle(saveRecipeCommand);

        verify(recipeRepository).saveRecipe(recipe);
    }
}
