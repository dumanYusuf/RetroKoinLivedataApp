package com.dumanyusuf.koinretrofit.domain.repo

import com.dumanyusuf.koinretrofit.data.remote.dto.CategoryDto

 interface  MealRepo {

     suspend fun getCategoryList():CategoryDto

}