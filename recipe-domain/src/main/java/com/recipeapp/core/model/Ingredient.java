
package com.recipeapp.core.model;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@Builder
@NoArgsConstructor
public class Ingredient {

    private String name;
    private String description;
    private List<String> category;
    private String quantity;

}
