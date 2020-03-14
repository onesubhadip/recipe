package recipe.steps;

import com.recipe.lib.cqs.CommandResult;
import com.recipeapp.core.model.Recipe;
import lombok.Data;
import recipe.RecipeMain;

import static org.assertj.core.api.Assertions.assertThat;

@Data
public class SaveRecipeSteps {

    private RecipeMain recipeApp;
    private CommandResult saveRecipeResult;

    public void submitsNewRecipe(Recipe recipe) {
        saveRecipeResult = recipeApp.getCreateRecipeTestAdapter().saveNewRecipe(recipe);
    }

    public void checkSavedRecipeId() {
        assertThat(saveRecipeResult).isNotNull();
        assertThat(saveRecipeResult.getCommandId()).isNotNull();
    }
}
