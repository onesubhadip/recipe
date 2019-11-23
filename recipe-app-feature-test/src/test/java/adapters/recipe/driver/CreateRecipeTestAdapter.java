package adapters.recipe.driver;


import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.in.CreateRecipeUseCase;

public class CreateRecipeTestAdapter {

    private CreateRecipeUseCase saveRecipeService;

    public void initiateSaveRecipeWorkflow() {
        SaveRecipeCommand saveRecipeCommand = new SaveRecipeCommand(Recipe.builder().build());
        saveRecipeService.createNewRecipe(saveRecipeCommand);
    }
}
