package recipe;

import com.recipeapp.core.command.handler.SaveRecipeCommandHandler;
import com.recipeapp.core.port.out.RecipeCommandRepositorySPI;
import com.recipeapp.core.service.SaveRecipeService;
import lombok.Getter;
import recipe.adapters.driven.MockRecipeRepositoryAdapter;
import recipe.adapters.driver.CreateRecipeTestAdapter;

public class RecipeMain {

    @Getter
    private CreateRecipeTestAdapter createRecipeTestAdapter;

    public void init() {

        RecipeCommandRepositorySPI recipeCommandRepositorySPI = MockRecipeRepositoryAdapter.getInstance();
        SaveRecipeCommandHandler saveRecipeCommandHandler = new SaveRecipeCommandHandler(recipeCommandRepositorySPI);
        SaveRecipeService saveRecipeService = new SaveRecipeService(saveRecipeCommandHandler);

        createRecipeTestAdapter = CreateRecipeTestAdapter.builder()
                .saveRecipeService(saveRecipeService)
                .build();
    }

}
