package com.dumanyusuf.koinretrofit.domain.use_case.get_filter_category

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.dumanyusuf.koinretrofit.data.remote.dto.toCategortFilter
import com.dumanyusuf.koinretrofit.domain.model.CategoryFilterModel
import com.dumanyusuf.koinretrofit.domain.repo.MealRepo
import com.dumanyusuf.koinretrofit.util.Resource

class GetFilterCategoryUseCase(private val repo: MealRepo) {


     fun getFilterCategory(c:String):LiveData<Resource<List<CategoryFilterModel>>> = liveData {
        try {
            emit(Resource.Loading())
           val myList= repo.getFilterCategory(c = c)
            if (myList.meals.isNotEmpty()){
                emit(Resource.Success(myList.toCategortFilter()))
            }
            else{
                emit(Resource.Error("not found"))
            }

        }
        catch (e:Exception){
            emit(Resource.Error("error:${e.localizedMessage}"))
        }
    }

}