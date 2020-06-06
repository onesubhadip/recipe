package com.recipeapp.core.query;

import com.recipe.lib.utils.QueryResult;
import com.recipeapp.core.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "with")
@NoArgsConstructor(staticName = "none")
@Getter
public class FindByIdResult implements QueryResult {

    private Recipe recipe;

}
