package recipe.adapters.driver;


import com.recipe.lib.utils.CommandResult;
import com.recipe.lib.utils.CommandStatus;
import com.recipeapp.core.command.SaveRecipeCommand;
import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.in.SaveRecipeUseCase;
import lombok.Builder;

@Builder
public class CreateRecipeTestAdapter {

    private SaveRecipeUseCase saveRecipeService;

    public CommandResult saveNewRecipe(Recipe recipe) {
        SaveRecipeCommand saveRecipeCommand = SaveRecipeCommand.with(recipe);
        saveRecipeService.saveRecipe(saveRecipeCommand);
        return CommandResult.builder()
                .commandId(recipe.getId())
                .status(CommandStatus.SUCCESS).build();
    }
}
