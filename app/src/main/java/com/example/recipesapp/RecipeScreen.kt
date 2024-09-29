package com.example.recipesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(viewState: MainViewModel.RecipeState, navigateToDetailScreen: (Category) -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
//                CircularProgressIndicator(Modifier.align(Alignment.Center))
                println("Loading")
            }

            viewState.error != null -> {
                Text(text = "Some Error has occured ${viewState.error}")
            }

            else -> {
                CategoryScreen(categories = viewState.list, navigateToDetailScreen)
            }
        }
    }
}

@Composable
fun CategoryScreen(categories: List<Category>, navigateToDetailScreen: (Category) -> Unit) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(categories){
            CategoryItem(categoryItem = it, navigateToDetailScreen)
        }
    }
}

@Composable
fun CategoryItem(categoryItem: Category, navigateToDetailScreen: (Category) -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize().clickable { navigateToDetailScreen(categoryItem) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        println(categoryItem.strCategoryThumb)
        Image(
            painter = rememberAsyncImagePainter(categoryItem.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().aspectRatio(1f)
        )
        
        Text(text = categoryItem.strCategory,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 4.dp))
    }
}