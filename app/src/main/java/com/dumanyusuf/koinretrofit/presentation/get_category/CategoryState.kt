package com.dumanyusuf.koinretrofit.presentation.get_category

import com.dumanyusuf.koinretrofit.domain.model.CategoryModel

data class CategoryState(
    val categoryList:List<CategoryModel> = emptyList(),
    val isLoading:Boolean=false,
    val error:String=""
)