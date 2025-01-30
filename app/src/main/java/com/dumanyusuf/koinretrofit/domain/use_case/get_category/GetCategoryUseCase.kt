package com.dumanyusuf.koinretrofit.domain.use_case.get_category


import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.dumanyusuf.koinretrofit.data.remote.dto.toCategory
import com.dumanyusuf.koinretrofit.domain.model.CategoryModel
import com.dumanyusuf.koinretrofit.domain.repo.MealRepo
import com.dumanyusuf.koinretrofit.util.Resource


class GetCategoryUseCase (private val repo: MealRepo){

    fun executeGetCategory():LiveData<Resource<List<CategoryModel>>>  = liveData{
         try {
             emit(Resource.Loading())
                val myList= repo.getCategoryList()
                if (myList.categories.isNotEmpty()){
                   emit(Resource.Success(myList.toCategory()))
                }

        }
        catch (e:Exception){
            emit(Resource.Error("Error:${e.localizedMessage}"))
        }
    }
    }
