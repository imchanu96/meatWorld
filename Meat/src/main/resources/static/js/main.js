

function showCategoryFnc(){ //카테고리 창 시작
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
        categoryDetailTag.style.zIndex = -10;
        categoryDetailTag.style.opacity = 0;
        categoryDetailTag.style.transition = "all 0.5s";
    })
} //카테고리 창 종료

var recipeImgLocation = "/img/recipe/";
var recipeImgList = [recipeImgLocation + "깐풍기-중식.png", recipeImgLocation + "닭꼬치(네기마)-일식.png", recipeImgLocation + "동파육-중식.png", recipeImgLocation + "부타동-일식.png", recipeImgLocation + "뷔프 부르기뇽-양식.png", recipeImgLocation + "비프 웰링턴-양식.png", recipeImgLocation + "스키야키-일식.png", recipeImgLocation + "스테이크-양식.png", recipeImgLocation + "아롱사태 수육-한식.png", recipeImgLocation + "오향장육-중식.png", recipeImgLocation + "제육볶음-한식.png", recipeImgLocation + "탕국-한식.png", recipeImgLocation + "파니니-양식.png"];

window.onload = function(){

    setInterval(changeMeatPartImgFnc, 5000)
    setInterval(changeRecipeImgFnc, 3000)
}

var showImg;


function changeMeatPartImgFnc(){
    // 고기 부위 설명 사진 변경
        var meatPartDescriptionList = document.getElementsByClassName("swiper_slide");

        showImg = meatPartDescriptionList[0];
        console.log("변경");
        for (let i = 0; i < meatPartDescriptionList.length; i++) {
            if(meatPartDescriptionList[i].className != "swiper_slide"){
                meatPartDescriptionList[i].classList.toggle("swiper_slide_show");

                if(i == meatPartDescriptionList.length-1){
                    meatPartDescriptionList[0].classList.toggle("swiper_slide_show");
                }else{
                    meatPartDescriptionList[i+1].classList.toggle("swiper_slide_show");
                    break;
                }
            }
        }
}

function changeRecipeImgFnc(){
    // // 오늘의 레시피 사진 변경
     var randomRecipeImg = document.getElementById("today_recipe").children[0].children[0];
     randomRecipeImg.src = recipeImgList[Math.floor(Math.random() * 13)];
     randomRecipeImg.style.width = "532.828px";
     randomRecipeImg.style.height = "400px";


}