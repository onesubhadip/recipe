
package com.recipeapp.core.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Ingredient {

    private String name;
    private String description;
    private List<String> category;
    private String quantity;

}
