package com.dumanyusuf.koinretrofit.data.repo

import com.dumanyusuf.koinretrofit.data.remote.MealApi
import com.dumanyusuf.koinretrofit.data.remote.dto.CategoryDto
import com.dumanyusuf.koinretrofit.data.remote.dto.CategoryFilterDto
import com.dumanyusuf.koinretrofit.domain.repo.MealRepo

class RepoImpl(private val api:MealApi):MealRepo{


    override suspend fun getCategoryList(): CategoryDto {
       return api.getCategoryList()
    }

    override suspend fun getFilterCategory(c:String): CategoryFilterDto {
        return api.getFilterCategory(c)
    }


}