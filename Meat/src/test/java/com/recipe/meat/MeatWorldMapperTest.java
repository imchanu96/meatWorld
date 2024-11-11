package com.recipe.meat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.recipe.meat.domain.mainPage.MainPageService;
import com.recipe.meat.domain.mainPage.MeatPartResponse;
import com.recipe.meat.domain.recpice.RecipeMapper;
import com.recipe.meat.domain.recpice.RecipeListRequest;
import com.recipe.meat.domain.recpice.RecipeListResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MeatWorldMapperTest {

    @Autowired
    RecipeMapper recipeMapper;

    @Autowired
    MainPageService mainPageService;


    @Test
    void saveRecipeList() {
        RecipeListRequest params = new RecipeListRequest();
        params.setCuisineId(1);
        params.setMeatPartId(1);
        params.setRecipeName("레시피 테스트 이름");
        params.setRecipeDescription("레시피 이름 설명 테스트");
        params.setRecipeEstimatedTime(60);
        params.setRecipeIngredients("테스트 재료1, 테스트 재료2");
        recipeMapper.saveRecipeList(params);

        List<RecipeListResponse> recipeLists = recipeMapper.findRecipeListAll();
        System.out.println("전체 게시글 개수는 : " + recipeLists.size() + "개입니다.");
    }

    @Test
    void updateRecipeList(){
        // 1. 레시피 리스트 수정
        RecipeListRequest params = new RecipeListRequest();
        params.setRecipeId(1);
        params.setCuisineId(1);
        params.setMeatPartId(1);
        params.setRecipeName("레시피 테스트 이름 수정1");
        params.setRecipeDescription("레시피 이름 설명 수정 테스트1");
        params.setRecipeEstimatedTime(60);
        params.setRecipeIngredients("테스트 수정 재료1, 테스트 수정 재료2");
        recipeMapper.updateRecipeList(params);

        // 2. 게시글 상세정보 조회
        RecipeListResponse recipeList = recipeMapper.findByRecipeId(1);
        try {
            String recipeListJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(recipeList);
            System.out.println(recipeListJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void delete(){
        System.out.println("삭제 이전의 전체 게시글 개수는 : " + recipeMapper.findRecipeListAll().size() + "개입니다.");
        recipeMapper.deleteByRecipeId(4);
        System.out.println("삭제 이후의 전체 게시글 개수는 : " + recipeMapper.findRecipeListAll().size() + "개입니다.");
    }

    @Test
    void meatPartListAll(){
        List<String> meatPartLists = mainPageService.findMeatPartTypeAll();
        for (int i = 0; i < meatPartLists.size(); i++) {
            System.out.println(meatPartLists.get(i));
        }
        System.out.println("전체 게시글 개수는 : " + meatPartLists.size() + "개입니다.");
    }

    @Test
    void findRecipeListAll(){
        List<RecipeListResponse> recipeLists = recipeMapper.findRecipeListAll();
        for (int i = 0; i < recipeLists.size(); i++) {
            System.out.println(recipeLists.get(i).getRecipeName());
        }
        System.out.println("전체 게시글 개수는 : " + recipeLists.size() + "개입니다.");
    }
}
