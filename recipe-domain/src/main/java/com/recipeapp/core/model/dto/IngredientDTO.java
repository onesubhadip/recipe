
package com.recipeapp.core.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class IngredientDTO {

    private String name;
    private String description;
    private List<String> category;
    private String quantity;

}
