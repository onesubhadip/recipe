package recipe.steps;

import com.recipe.lib.cqs.CommandResult;
import lombok.Data;
import recipe.RecipeMain;

import static org.assertj.core.api.Assertions.assertThat;

@Data
public class SaveRecipeSteps {

    private RecipeMain recipeApp;
    private CommandResult saveRecipeResult;

    public void submitsNewRecipe() {
        saveRecipeResult = recipeApp.getCreateRecipeTestAdapter().saveNewRecipe();
    }

    public void checkSavedRecipeId() {
        assertThat(saveRecipeResult).isNotNull();
        assertThat(saveRecipeResult.getCommandId()).isNotNull();
    }
}
