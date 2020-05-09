package integration.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipeapp.core.model.dto.AttributesDTO;
import com.recipeapp.core.model.dto.RecipeDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Slf4j
public class SaveNewRecipeUseCase {

    private final String baseUrl = "http://localhost:8080";
    private final String saveRecipeEndpoint = "/recipe";

    @Test
    public void test() throws JsonProcessingException {
        log.info("Integration test - RUNNIG");
        RecipeDTO recipe = new RecipeDTO();
        recipe.setName("First Recipe");
        recipe.setShortDescription("A brief recipe");
        recipe.setAttributes(new AttributesDTO());
        recipe.setIngredients(Collections.emptyList());
        recipe.setSteps(Collections.emptyList());
        String recipePayload = new ObjectMapper().writeValueAsString(recipe);

        given()
            .contentType("application/json")
            .body(recipePayload)
        .when()
            .post(baseUrl + saveRecipeEndpoint)
        .then()
            .statusCode(is(201))
            .body("status", is("SUCCESS"));
    }
}
