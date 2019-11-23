package adapters.recipe.driven;

import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.out.RecipeRepositorySPI;

public class MockRecipeRepositoryAdapter implements RecipeRepositorySPI {

    @Override
    public void accept(Recipe recipe) {

    }

    @Override
    public void saveRecipe(Recipe recipe) {

    }
}
