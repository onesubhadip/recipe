package com.recipeapp.query.web;

import com.recipe.lib.utils.Query;
import com.recipe.lib.utils.QueryHandler;
import com.recipe.lib.utils.QueryName;
import com.recipe.lib.utils.QueryResult;
import com.recipeapp.core.port.in.GetRecipeUseCase;
import com.recipeapp.core.query.FindRecipeByIdQuery;
import com.recipeapp.query.util.QueryGenerator;
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
    private Map<String, QueryHandler> queryHandlerMap;

    @Autowired
    private Map<String, QueryGenerator> queryGeneratorMap;

    @GetMapping("/recipe")
    public ResponseEntity<QueryResult> getRecipeForId(@RequestParam("q") final String query,
                                                      final HttpServletRequest request) {

        Map<String, String[]> requestParameterMap = request.getParameterMap();
        String id = requestParameterMap.get("id")[0];

        QueryGenerator queryGenerator = queryGeneratorMap.get(query);
        Query recipeQuery = queryGenerator.generate(requestParameterMap);

        QueryResult queryResult = ((GetRecipeUseCase) queryHandlerMap.get(query)).getRecipe(recipeQuery);
        return ResponseEntity.ok(queryResult);
    }
}



//q=findById
//id=1 [HTTPRequestParam]
//
//q = findRecipeHavingIngredients
//igs=[a,b,c] [HTTPRequestParam]
//max=3[HTTPRequestParam]
//
//Query(FindRecipeByIdQuery) queryPayloadCreator.create(HTTPRequestParam ...){}
//
//
//FindByIdQueryCreator.create(HTTPRequestParam ...) implements QueryCreator
