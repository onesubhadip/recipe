package com.recipeapp.query.web;

import com.recipe.lib.utils.Query;
import com.recipe.lib.utils.QueryHandler;
import com.recipe.lib.utils.QueryResult;
import com.recipeapp.core.port.in.GetRecipeUseCase;
import com.recipeapp.query.util.QueryGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class GetRecipeController {

    @Autowired
    @Qualifier("queryHandlerMap")
    private Map<String, QueryHandler> queryHandlerMap;

    @Autowired
    @Qualifier("queryGeneratorMap")
    private Map<String, QueryGenerator> queryGeneratorMap;

    @GetMapping("/recipe")
    public ResponseEntity<QueryResult> getRecipeForId(@RequestParam("q") final String query,
                                                      final HttpServletRequest request) {

        Map<String, String[]> requestParameterMap = request.getParameterMap();

        QueryGenerator queryGenerator = queryGeneratorMap.get(query);
        Query recipeQuery = queryGenerator.generate(requestParameterMap);

        QueryResult queryResult = ((GetRecipeUseCase) queryHandlerMap.get(query)).getRecipe(recipeQuery);
        return ResponseEntity.ok(queryResult);
    }
}
