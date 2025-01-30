package com.dumanyusuf.koinretrofit.domain.repo

import com.dumanyusuf.koinretrofit.data.remote.dto.CategoryDto
import com.dumanyusuf.koinretrofit.data.remote.dto.CategoryFilterDto

interface  MealRepo {

     suspend fun getCategoryList():CategoryDto
     suspend fun getFilterCategory(c:String):CategoryFilterDto

}