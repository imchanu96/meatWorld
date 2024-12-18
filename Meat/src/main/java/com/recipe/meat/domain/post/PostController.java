package com.recipe.meat.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //게시글 작성 페이지
    @GetMapping("/#")
    public String openPostWrite(Model model){
        return "#";
    }
}
