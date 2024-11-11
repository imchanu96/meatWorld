package com.recipe.meat.domain.recpice;

import lombok.Getter;

@Getter
public class RecipeListResponse {
    private int recipeId;                       // PK
    private int cuisineId;                          // 퀴진 번호
    private int meatPartId;                         // 부위 번호
    private String recipeName;                      // 레시피 이름
    private String recipeDescription;               // 레시피 설명
    private int recipeEstimatedTime;                // 레시피 소요 예상시간
    private String recipeIngredients;               // 레시피 재료
}
