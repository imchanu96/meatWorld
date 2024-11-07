function showCategoryFnc(){
    var categoryDetailTag = document.getElementById("category_detail_section");
    categoryDetailTag.style.transition = "all 0.5s";
    categoryDetailTag.style.zIndex = 10;
    categoryDetailTag.style.opacity = 100;
    
    var categoryDetailTagList = document.getElementById("category_detail").children;
    var categoryDetailTagHeight = categoryDetailTagList[0].getBoundingClientRect().height;

    for (let i = 1; i < categoryDetailTagList.length; i++) {
        var elementHeight = categoryDetailTagList[i]. getBoundingClientRect().height; 
        if (elementHeight >= categoryDetailTagHeight) {
            categoryDetailTagHeight = elementHeight;
        }
        
    }

    categoryDetailTag.style.height = categoryDetailTagHeight + "px";

    var subCategoryWidth = document.getElementsByClassName("category_list")[0].getBoundingClientRect().width;
    var subCategoryList = categoryDetailTag.children[1].children; //서브 카테고리 리스트
    for (let i = 0; i < subCategoryList.length; i++) {
        subCategoryList[i].style.width = subCategoryWidth + "px";
        
    }

    categoryDetailTag.addEventListener("mouseleave", function(){
        categoryDetailTag.style.height = "0";
        categoryDetailTag.style.zIndex = 0;
        categoryDetailTag.style.opacity = 0;
        categoryDetailTag.style.transition = "all 0.5s";
    })
}