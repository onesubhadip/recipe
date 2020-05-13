package com.recipeapp.core.query;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class FindRecipeByIdQuery implements Query{
    private final UUID id;

    @Override
    public QueryName getName() {
        return QueryName.findById;
    }
}
