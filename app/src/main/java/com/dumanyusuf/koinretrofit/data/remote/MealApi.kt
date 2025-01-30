package com.dumanyusuf.koinretrofit.data.remote

import com.dumanyusuf.koinretrofit.data.remote.dto.CategoryDto
import com.dumanyusuf.koinretrofit.data.remote.dto.CategoryFilterDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {


    @GET("/api/json/v1/1/categories.php ")
    suspend fun getCategoryList():CategoryDto

    @GET("/api/json/v1/1/filter.php?c=Seafood")
    suspend fun getFilterCategory(
        @Query("c") c: String
    ):CategoryFilterDto

}