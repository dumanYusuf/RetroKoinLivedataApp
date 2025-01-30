package com.dumanyusuf.koinretrofit.presentation.get_filter_category

import com.dumanyusuf.koinretrofit.domain.model.CategoryFilterModel

data class CategortFilterState(
    val myCategoryFilterList:List<CategoryFilterModel> = emptyList(),
    val isLoading:Boolean=false,
    val error:String=""
)
