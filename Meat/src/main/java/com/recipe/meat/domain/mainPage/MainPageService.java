package com.recipe.meat.domain.mainPage;

import com.recipe.meat.domain.post.PostResponse;
import com.recipe.meat.domain.recpice.CuisineListResponse;
import com.recipe.meat.domain.recpice.RecipeListResponse;
import com.recipe.meat.domain.recpice.RecipeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainPageService {
    private final MainPageMapper mainPageMapper;
    private final RecipeMapper recipeMapper;

    /**
     * 고기부위 리스트 조회
     * @return 게시글 리스트
     */
    public List<String> findMeatPartTypeAll(){
        return mainPageMapper.findMeatPartTypeAll();
    }

    /**
     * 고기부위 리스트 조회
     * @return 게시글 리스트
     */
    public List<CuisineListResponse> findCuisineAll(){
        return mainPageMapper.findCuisineAll();
    }

    /**
     * 레시피 리스트 조회
     * @return 게시글 리스트
     */
    public List<RecipeListResponse> findRecipeAll(){
        return mainPageMapper.findRecipeAll();
    }

    /**
     * 레시피 리스트 조회
     * @return 게시글 리스트
     */
//    public List<PostResponse> findPostAll(){
//        return mainPageMapper.findPostAll();
//    }
}
