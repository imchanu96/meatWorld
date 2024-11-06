function showCategoryFnc(){
    categoryDetailTag = document.getElementById("category_detail_section");
    categoryDetailTag.style.transition = "all 0.5s";
    categoryDetailTag.style.height = "300%";
    categoryDetailTag.style.zIndex = 10;
    categoryDetailTag.style.opacity = 100;
    categoryDetailTag.style.position = "relative";

    categoryDetailTag.addEventListener("mouseleave", function(){
        categoryDetailTag.style.height = "0";
        categoryDetailTag.style.zIndex = 0;
        categoryDetailTag.style.opacity = 0;
        categoryDetailTag.style.transition = "all 0.5s";
    })
}