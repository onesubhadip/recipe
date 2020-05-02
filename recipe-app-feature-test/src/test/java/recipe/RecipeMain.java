package recipe;

import com.recipeapp.core.command.handler.SaveRecipeCommandHandler;
import com.recipeapp.core.port.out.RecipeRepositorySPI;
import com.recipeapp.core.service.SaveRecipeService;
import lombok.Getter;
import recipe.adapters.driven.MockRecipeRepositoryAdapter;
import recipe.adapters.driver.CreateRecipeTestAdapter;

public class RecipeMain {

    @Getter
    private CreateRecipeTestAdapter createRecipeTestAdapter;

    public void init() {

        RecipeRepositorySPI recipeRepositorySPI = MockRecipeRepositoryAdapter.getInstance();
        SaveRecipeCommandHandler saveRecipeCommandHandler = new SaveRecipeCommandHandler(recipeRepositorySPI);
        SaveRecipeService saveRecipeService = new SaveRecipeService(saveRecipeCommandHandler);

        createRecipeTestAdapter = CreateRecipeTestAdapter.builder()
                .saveRecipeService(saveRecipeService)
                .build();
    }

}
