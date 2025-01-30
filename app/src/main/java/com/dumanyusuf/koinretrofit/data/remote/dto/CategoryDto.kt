package com.dumanyusuf.koinretrofit.data.remote.dto

import com.dumanyusuf.koinretrofit.domain.model.CategoryModel

data class CategoryDto(
    val categories: List<Category>
)

fun CategoryDto.toCategory():List<CategoryModel>{
    return categories.map{
        CategoryModel(
            idCategory = it.idCategory,
            strCategory = it.strCategory,
            strCategoryThumb = it.strCategoryThumb
        )
    }
}