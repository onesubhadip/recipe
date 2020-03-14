package com.recipeapp.core.service;


import com.recipe.lib.cqs.CommandResult;
import com.recipe.lib.cqs.CommandStatus;
import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.command.handler.SaveRecipeCommandHandler;
import com.recipeapp.core.model.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class SaveRecipeServiceTest {
    @Mock
    private SaveRecipeCommandHandler recipeCommandHandler;

    private CreateRecipeService createRecipeService;

    @BeforeEach
    public void init() {
        createRecipeService = new CreateRecipeService(recipeCommandHandler);
    }

    @Test
    public void whenSaveRecipeSuccess_ShouldReturnUUID() {
        SaveRecipeCommand saveRecipeCommand = new SaveRecipeCommand(Mockito.mock(Recipe.class));
        given(recipeCommandHandler.handle(saveRecipeCommand))
                .willReturn(CommandResult.builder()
                        .commandId(UUID.randomUUID())
                        .commandName("SaveRecipe")
                        .status(CommandStatus.SUCCESS)
                        .build());

        CommandResult saveRecipeResult = createRecipeService.createNewRecipe(saveRecipeCommand);
        assertThat(saveRecipeResult).isNotNull();
        assertThat(saveRecipeResult.getCommandName()).isEqualTo("SaveRecipe");
        assertThat(saveRecipeResult.getStatus()).isEqualTo(CommandStatus.SUCCESS);
        assertThat(saveRecipeResult.getCommandId()).isNotNull();
    }
}
