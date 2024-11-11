package com.recipe.meat.domain.mainPage;

import com.recipe.meat.domain.post.PostResponse;
import com.recipe.meat.domain.recpice.CuisineListResponse;
import com.recipe.meat.domain.recpice.RecipeListResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainPageMapper {

    /**
     * 고기부위 리스트 조회
     * @return 게시글 리스트
     */
    List<String> findMeatPartTypeAll();

    /**
     * 레시피 리스트 조회
     * @return 게시글 리스트
     */
    List<RecipeListResponse> findRecipeAll();

    /**
     * 퀴진 리스트 조회
     * @return 게시글 리스트
     */
    List<CuisineListResponse> findCuisineAll();
    /**
     * 레시피 리스트 조회
     * @return 게시글 리스트
     */
//    List<PostResponse> findPostAll();


}
