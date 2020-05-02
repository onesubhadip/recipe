package recipe.steps;

import com.recipe.lib.utils.CommandResult;
import com.recipeapp.core.model.Recipe;
import com.recipeapp.core.model.Steps;
import com.recipeapp.core.model.dto.RecipeDTO;
import com.recipeapp.core.model.dto.StepsDTO;
import com.recipeapp.core.utils.RecipeModelMapper;
import lombok.Data;
import recipe.RecipeMain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Data
public class SaveRecipeSteps {

    private RecipeMain recipeApp;
    private CommandResult saveRecipeResult;

    public void submitsNewRecipe(RecipeDTO recipeDto) {

        Recipe recipe = RecipeModelMapper.mapRecipeDtoToDomain(recipeDto);
        recipe.setId(UUID.randomUUID());
        saveRecipeResult = recipeApp.getCreateRecipeTestAdapter().saveNewRecipe(recipe);
    }

    private List<Steps> mapStepsDtoToDomain(final List<StepsDTO> stepsDTOList) {
        return Objects.nonNull(stepsDTOList) ? stepsDTOList.stream()
                .map(stepsDTO -> Steps.builder()
                        .heading(stepsDTO.getHeading())
                        .stepSequence(stepsDTO.getStepSequence())
                        .subHeading(stepsDTO.getSubHeading())
                        .description(stepsDTO.getDescription())
                        .estimatedTime(stepsDTO.getEstimatedTime())
                        .images(stepsDTO.getImages())
                        .subSteps(mapStepsDtoToDomain(stepsDTO.getSubSteps()))
                        .build())
                .collect(Collectors.toList())
                : Collections.emptyList();
    }

    public void checkSavedRecipeId() {
        assertThat(saveRecipeResult).isNotNull();
        assertThat(saveRecipeResult.getCommandId()).isNotNull();
    }
}
