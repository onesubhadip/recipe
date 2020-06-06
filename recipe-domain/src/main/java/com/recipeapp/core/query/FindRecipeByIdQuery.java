package com.recipeapp.core.query;

import com.recipe.lib.utils.NamedQuery;
import com.recipe.lib.utils.Query;
import com.recipe.lib.utils.QueryName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor(staticName = "with")
@NoArgsConstructor
@NamedQuery(QueryName.findById)
public class FindRecipeByIdQuery implements Query {
    private UUID id;

    @Override
    public QueryName name() {
        return QueryName.findById;
    }
}
