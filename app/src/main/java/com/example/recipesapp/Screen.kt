package com.example.recipesapp

sealed class Screen(val route: String){
    object RecipeScreen: Screen("recipescreen")
    object DetailScreen: Screen("detailscreen")
}