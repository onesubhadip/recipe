package recipe.adapters.driven;

import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.out.RecipeCommandRepositorySPI;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "getInstance")
public class MockRecipeRepositoryAdapter implements RecipeCommandRepositorySPI {

    @Override
    public void saveRecipe(Recipe recipe) {

    }
}
