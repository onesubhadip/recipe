
package com.recipeapp.core.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@Builder
@NoArgsConstructor
public class Steps {

    private String stepSequence;
    private String heading;
    private String subHeading;
    private String description;
    private List<String> images;
    private List<Steps> subSteps;
    private String estimatedTime;

}
