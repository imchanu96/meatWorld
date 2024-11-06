package com.recipe.meat.domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeatworldMapper {
    /**
     * 레시피 저장
     * @param params - 레시피 정보
     */
    void saveRecipeList(RecipeListRequest params);

    /**
     * 레시피 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    RecipeListResponse findByRecipeId(int id);

    /**
     * 레시피 수정
     * @param params - 레시피 정보
     */
    void updateRecipeList(RecipeListRequest params);

    /**
     * 레시피 삭제
     * @param id - PK
     */
    void deleteByRecipeId(int id);

    /**
     * 레시피 리스트 조회
     * @return 게시글 리스트
     */
    List<RecipeListResponse> findRecipeListAll();

    /**
     * 레시피 수 카운팅
     * @return 게시글 수
     */
    //int count();
}
