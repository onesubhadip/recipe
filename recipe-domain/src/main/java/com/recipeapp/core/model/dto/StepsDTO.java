
package com.recipeapp.core.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StepsDTO {

    private String stepSequence;
    private String heading;
    private String subHeading;
    private String description;
    private List<String> images;
    private List<StepsDTO> subSteps;
    private String estimatedTime;

}
