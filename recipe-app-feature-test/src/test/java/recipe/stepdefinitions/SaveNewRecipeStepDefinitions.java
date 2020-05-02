package recipe.stepdefinitions;

import com.recipeapp.core.model.dto.RecipeDTO;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import recipe.RecipeMain;
import recipe.steps.SaveRecipeSteps;

import java.io.InputStream;

public class SaveNewRecipeStepDefinitions {

    @Steps
    private SaveRecipeSteps author;

    @Before
    public void initRecipeApp() {
        RecipeMain recipeMain = new RecipeMain();
        recipeMain.init();
        author.setRecipeApp(recipeMain);
    }

    @Given("Alice has an account")
    @Pending
    public void alice_has_an_account() {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @Given("Alice has logged into the application")
    public void alice_has_logged_into_the_application() {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @When("Alice submits a new recipe like in file {string}")
    public void alice_submits_a_new_recipe(String recipeFile) {
        Yaml yaml = new Yaml(new Constructor(RecipeDTO.class));
        InputStream recipeStream = getClass().getClassLoader().getResourceAsStream(recipeFile);
        RecipeDTO recipe = yaml.load(recipeStream);
        System.out.println(recipe);
        author.submitsNewRecipe(recipe);
    }

    @Then("Recipe is saved")
    public void recipe_is_saved() {
        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
        author.checkSavedRecipeId();
    }

}
