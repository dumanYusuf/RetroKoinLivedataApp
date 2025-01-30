package com.dumanyusuf.koinretrofit.data.remote

import com.dumanyusuf.koinretrofit.data.remote.dto.CategoryDto
import retrofit2.http.GET

interface MealApi {


    @GET("/api/json/v1/1/categories.php ")
    suspend fun getCategoryList():CategoryDto

}