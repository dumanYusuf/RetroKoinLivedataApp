package com.dumanyusuf.koinretrofit.data.remote.dto

import com.dumanyusuf.koinretrofit.domain.model.CategoryFilterModel

data class CategoryFilterDto(
    val meals: List<Meal>
)

fun CategoryFilterDto.toCategortFilter():List<CategoryFilterModel>{
    return meals.map {
        CategoryFilterModel(it.idMeal,it.strMeal,it.strMealThumb)
    }
}