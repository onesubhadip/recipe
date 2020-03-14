package com.recipeapp.core.command.handler;

import com.recipe.lib.cqs.CommandResult;
import com.recipe.lib.cqs.CommandStatus;
import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.out.RecipeRepositorySPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;

@ExtendWith(MockitoExtension.class)
public class SaveRecipeCommandHandlerTest {
    private SaveRecipeCommandHandler saveRecipeCommandHandler;

    @Mock
    private RecipeRepositorySPI recipeRepository;

    @BeforeEach
    public void init() {
        saveRecipeCommandHandler = new SaveRecipeCommandHandler(recipeRepository);
    }

    @Test
    public void saveRecipeShouldPersistRecipeAndReturnSuccessResult() {
        willDoNothing().given(recipeRepository).saveRecipe(any(Recipe.class));
        Recipe recipe = new Recipe();
        recipe.setRecipeId(UUID.randomUUID());
        CommandResult commandResult = saveRecipeCommandHandler.handle(new SaveRecipeCommand(recipe));

        assertThat(commandResult).isNotNull();
        assertThat(commandResult.getCommandId()).isNotNull();
        assertThat(commandResult.getCommandName()).isEqualTo("SaveRecipeCommand");
        assertThat(commandResult.getStatus()).isEqualTo(CommandStatus.SUCCESS);
    }
}
