package recipe.adapters.driver;


import com.recipe.lib.cqs.CommandResult;
import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.in.CreateRecipeUseCase;
import lombok.Builder;

@Builder
public class CreateRecipeTestAdapter {

    private CreateRecipeUseCase saveRecipeService;

    public CommandResult saveNewRecipe(Recipe recipe) {
        SaveRecipeCommand saveRecipeCommand = SaveRecipeCommand.with(recipe);
        return saveRecipeService.createNewRecipe(saveRecipeCommand);
    }
}
