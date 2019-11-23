package recipe.adapters.driven;

import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.out.RecipeRepositorySPI;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "getInstance")
public class MockRecipeRepositoryAdapter implements RecipeRepositorySPI {

    @Override
    public void saveRecipe(Recipe recipe) {

    }
}
