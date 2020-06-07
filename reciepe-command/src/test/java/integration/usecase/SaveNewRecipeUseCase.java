package integration.usecase;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Slf4j
public class SaveNewRecipeUseCase {

    private final String baseUrl = "http://localhost:8080";
    private final String saveRecipeEndpoint = "/recipe";

    @Test
    public void test() {
        InputStream payload = this.getClass().getClassLoader()
                .getResourceAsStream("payloads/recipe-1.json");

        given()
            .contentType("application/json")
            .body(payload)
        .when()
            .post(baseUrl + saveRecipeEndpoint)
        .then()
            .statusCode(is(201))
            .body("status", is("SUCCESS"));
    }
}
