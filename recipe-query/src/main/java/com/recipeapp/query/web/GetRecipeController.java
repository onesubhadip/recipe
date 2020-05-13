package com.recipeapp.query.web;

import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.port.in.GetRecipeUseCase;
import com.recipeapp.core.query.FindRecipeByIdQuery;
import com.recipeapp.core.query.Query;
import com.recipeapp.core.query.QueryName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

@RestController
public class GetRecipeController {
    @Autowired
    private GetRecipeUseCase getRecipeService;

    @GetMapping("/recipe")
    public ResponseEntity<Recipe> getRecipeForId(@RequestParam("q") final String query,
                                                 final HttpServletRequest request) {

        Map<String, String[]> requestParameterMap = request.getParameterMap();
        String id = requestParameterMap.get("id")[0];

        Query recipeQuery=null;
        if (query.equals(QueryName.findById.name())) {
            recipeQuery = new FindRecipeByIdQuery(UUID.fromString(id));
        }
        Recipe recipe = getRecipeService.getRecipe(recipeQuery);
        return ResponseEntity.ok(recipe);
    }
}
