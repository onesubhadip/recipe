package recipe;

import com.recipeapp.core.command.handler.SaveRecipeCommandHandler;
import com.recipeapp.core.port.out.RecipeRepositorySPI;
import com.recipeapp.core.service.CreateRecipeService;
import lombok.Getter;
import recipe.adapters.driven.MockRecipeRepositoryAdapter;
import recipe.adapters.driver.CreateRecipeTestAdapter;

public class RecipeMain {

    @Getter
    private CreateRecipeTestAdapter createRecipeTestAdapter;

    public void init() {

        RecipeRepositorySPI recipeRepositorySPI = MockRecipeRepositoryAdapter.getInstance();
        SaveRecipeCommandHandler saveRecipeCommandHandler = new SaveRecipeCommandHandler(recipeRepositorySPI);
        CreateRecipeService createRecipeService = new CreateRecipeService(saveRecipeCommandHandler);

        createRecipeTestAdapter = CreateRecipeTestAdapter.builder()
                .saveRecipeService(createRecipeService)
                .build();
    }

}
