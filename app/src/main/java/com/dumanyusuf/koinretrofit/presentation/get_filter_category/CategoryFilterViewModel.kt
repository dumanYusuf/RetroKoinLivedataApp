package com.dumanyusuf.koinretrofit.presentation.get_filter_category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dumanyusuf.koinretrofit.domain.use_case.get_filter_category.GetFilterCategoryUseCase
import com.dumanyusuf.koinretrofit.presentation.get_category.CategoryState
import com.dumanyusuf.koinretrofit.util.Resource

class CategoryFilterViewModel(private val getFilterCategoryUseCase: GetFilterCategoryUseCase):ViewModel() {


    private val _state = MutableLiveData<CategortFilterState>()
    val state: LiveData<CategortFilterState> = _state



    fun getFilterCategory(c:String) {
        getFilterCategoryUseCase.getFilterCategory(c).observeForever { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = CategortFilterState(myCategoryFilterList = resource.data ?: emptyList())
                    Log.e("başarılı", "veriler geldi: ${resource.data}")
                }
                is Resource.Error -> {
                    _state.value = CategortFilterState(error = "hata çıktı: ${resource.message}")
                    Log.e("başarısız", "veriler gelmedi: ${resource.message}")
                }
                is Resource.Loading -> {
                    _state.value = CategortFilterState(isLoading = true)
                }
            }
        }
    }


}