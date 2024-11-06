package com.recipe.meat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.recipe.meat.domain.MeatworldMapper;
import com.recipe.meat.domain.RecipeListRequest;
import com.recipe.meat.domain.RecipeListResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MeatWorldMapperTest {

    @Autowired
    MeatworldMapper meatworldMapper;


    @Test
    void saveRecipeList() {
        RecipeListRequest params = new RecipeListRequest();
        params.setCuisineId(1);
        params.setMeatPartId(1);
        params.setRecipeName("레시피 테스트 이름");
        params.setRecipeDescription("레시피 이름 설명 테스트");
        params.setRecipeEstimatedTime(60);
        params.setRecipeIngredients("테스트 재료1, 테스트 재료2");
        meatworldMapper.saveRecipeList(params);

        List<RecipeListResponse> recipeLists = meatworldMapper.findRecipeListAll();
        System.out.println("전체 게시글 개수는 : " + recipeLists.size() + "개입니다.");
    }

    @Test
    void updateRecipeList(){
        // 1. 레시피 리스트 수정
        RecipeListRequest params = new RecipeListRequest();
        params.setRecipeListId(1);
        params.setCuisineId(1);
        params.setMeatPartId(1);
        params.setRecipeName("레시피 테스트 이름 수정1");
        params.setRecipeDescription("레시피 이름 설명 수정 테스트1");
        params.setRecipeEstimatedTime(60);
        params.setRecipeIngredients("테스트 수정 재료1, 테스트 수정 재료2");
        meatworldMapper.updateRecipeList(params);

        // 2. 게시글 상세정보 조회
        RecipeListResponse recipeList = meatworldMapper.findByRecipeId(1);
        try {
            String recipeListJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(recipeList);
            System.out.println(recipeListJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void delete(){
        System.out.println("삭제 이전의 전체 게시글 개수는 : " + meatworldMapper.findRecipeListAll().size() + "개입니다.");
        meatworldMapper.deleteByRecipeId(4);
        System.out.println("삭제 이후의 전체 게시글 개수는 : " + meatworldMapper.findRecipeListAll().size() + "개입니다.");
    }
}
