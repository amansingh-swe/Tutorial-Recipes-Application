package com.example.recipesapp

data class Category(
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription : String
)

data class CategoriesResponse(val categories: List<Category>)