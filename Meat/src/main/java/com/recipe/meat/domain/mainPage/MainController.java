package com.recipe.meat.domain.mainPage;

import com.recipe.meat.domain.recpice.RecipeListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainPageService MainPageService;

    //게시글 작성 페이지
    @GetMapping("/meatworld/main.do")
    public String openPostWrite(Model model){
        return "meatworld/main";
    }
}