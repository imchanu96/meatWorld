package com.recipe.meat.domain.mainPage;

import com.recipe.meat.domain.recpice.CuisineListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class MainApiController {

    @Autowired
    private MainPageService mainPageService;


    @GetMapping("/meatPartList")
    public List<String> getMeatPartList(){
        return mainPageService.findMeatPartTypeAll();
    }

    @GetMapping("/cuisineMap")
    public Map<String, List<String>> getCuisionList(){
        List<CuisineListResponse> cuisineList = mainPageService.findCuisineAll();
        Set<String> cuisineMajorCategorySet = new HashSet<>();
        Set<String> cuisineMinorCategorySet = new HashSet<>();

        // 전체 리스트를 한 번만 순회
        for (CuisineListResponse cuisine : cuisineList) {
            cuisineMajorCategorySet.add(cuisine.getCuisineMajorCategory());
            cuisineMinorCategorySet.add(cuisine.getCuisineMinorCategory());
        }

        // Set을 List로 변환
        List<String> cuisineMajorCategoryList = new ArrayList<>(cuisineMajorCategorySet);
        List<String> cuisineMinorCategoryList = new ArrayList<>(cuisineMinorCategorySet);

        // Map에 담아서 반환
        Map<String, List<String>> cuisineMap = new HashMap<>();

        // 중복되지 않은 cuisineMajorCategoryList의 크기만큼 map에 저장
        for (int i = 0; i < cuisineMajorCategorySet.size(); i++) {
            cuisineMap.put(cuisineMajorCategoryList.get(i), new ArrayList<>());
        }
        //대분류별로 소분류의 값들을 넣음
        for (int i = 0; i < cuisineList.size(); i++) {
            cuisineMap.get(cuisineList.get(i).getCuisineMajorCategory()).add(cuisineList.get(i).getCuisineMinorCategory());
        }
        return cuisineMap;
    }
}
