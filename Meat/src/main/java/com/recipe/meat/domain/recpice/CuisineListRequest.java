package com.recipe.meat.domain.recpice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuisineListRequest {
    private int cuisineId;
    private String cuisineMajorCategory;
    private String cuisineMinorCategory;
}
