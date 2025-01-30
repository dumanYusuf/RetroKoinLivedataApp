package com.dumanyusuf.koinretrofit.presentation.get_category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dumanyusuf.koinretrofit.domain.use_case.get_category.GetCategoryUseCase
import com.dumanyusuf.koinretrofit.util.Resource
import kotlinx.coroutines.launch

class CategoryViewModel(private val getCategoryUseCase: GetCategoryUseCase):ViewModel() {

    private val _state = MutableLiveData<CategoryState>()
    val state: LiveData<CategoryState> = _state

    init {
        getCategory()
    }

    fun getCategory() {
        getCategoryUseCase.executeGetCategory().observeForever { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = CategoryState(categoryList = resource.data ?: emptyList())
                    Log.e("başarılı", "veriler geldi: ${resource.data}")
                }
                is Resource.Error -> {
                    _state.value = CategoryState(error = "hata çıktı: ${resource.message}")
                    Log.e("başarısız", "veriler gelmedi: ${resource.message}")
                }
                is Resource.Loading -> {
                    _state.value = CategoryState(isLoading = true)
                }
            }
        }
    }


}