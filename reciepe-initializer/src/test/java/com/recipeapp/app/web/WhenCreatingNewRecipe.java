package com.recipeapp.app.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.lib.cqs.CommandResult;
import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.in.CreateRecipeUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static com.recipe.lib.cqs.CommandStatus.SUCCESS;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

@WebMvcTest(controllers = CreateRecipeController.class)
class WhenCreatingNewRecipe {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateRecipeUseCase createRecipeService;


    @Test
    public void shouldSaveTheRecipeAndReturnANewRecipeId() throws Exception {

        Recipe recipe = new Recipe();
        recipe.setName("First Recipe");
        recipe.setShortDescription("A brief recipe");

        CommandResult expectedResult = CommandResult.builder()
                .commandId(UUID.randomUUID())
                .status(SUCCESS)
                .build();

        given(createRecipeService.createNewRecipe(any(SaveRecipeCommand.class))).willReturn(expectedResult);

        String recipePayload = new ObjectMapper().writeValueAsString(recipe);

        mockMvc.perform(MockMvcRequestBuilders.post("/recipe")
        .contentType(MediaType.APPLICATION_JSON)
        .content(recipePayload)
        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.commandId").value(expectedResult.getCommandId().toString()));
    }
}