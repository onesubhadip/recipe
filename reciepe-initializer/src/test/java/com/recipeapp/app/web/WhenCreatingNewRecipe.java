package com.recipeapp.app.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipeapp.core.model.dto.AttributesDTO;
import com.recipeapp.core.model.dto.RecipeDTO;
import com.recipeapp.core.port.in.SaveRecipeUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SaveRecipeController.class)
class WhenCreatingNewRecipe {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SaveRecipeUseCase createRecipeService;


    @Test
    public void shouldSaveTheRecipeAndReturnANewRecipeId() throws Exception {

        RecipeDTO recipe = new RecipeDTO();
        recipe.setName("First Recipe");
        recipe.setShortDescription("A brief recipe");
        recipe.setAttributes(new AttributesDTO());
        recipe.setIngredients(Collections.emptyList());
        recipe.setSteps(Collections.emptyList());

        String recipePayload = new ObjectMapper().writeValueAsString(recipe);

        mockMvc.perform(MockMvcRequestBuilders.post("/recipe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(recipePayload)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.commandId").exists())
                .andExpect(jsonPath("$.status").value("SUCCESS"));
    }

    @Test
    public void shouldUpdateTheRecipeForRecipeId() throws Exception {

        RecipeDTO recipe = new RecipeDTO();
        recipe.setName("First Recipe");
        recipe.setShortDescription("A brief recipe");
        recipe.setAttributes(new AttributesDTO());
        recipe.setIngredients(Collections.emptyList());
        recipe.setSteps(Collections.emptyList());

        String recipePayload = new ObjectMapper().writeValueAsString(recipe);
        String id = UUID.randomUUID().toString();
        mockMvc.perform(MockMvcRequestBuilders.put("/recipe/".concat(id))
                .contentType(MediaType.APPLICATION_JSON)
                .content(recipePayload)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.commandId").value(id))
                .andExpect(jsonPath("$.status").value("SUCCESS"));
    }
}