package com.dumanyusuf.koinretrofit.presentation.get_filter_category

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dumanyusuf.koinretrofit.domain.model.CategoryFilterModel
import com.dumanyusuf.koinretrofit.domain.use_case.get_filter_category.GetFilterCategoryUseCase
import com.dumanyusuf.koinretrofit.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryFilterViewModel(private val getFilterCategoryUseCase: GetFilterCategoryUseCase) : ViewModel() {

    private val _state = MutableLiveData<CategortFilterState>()
    val state: LiveData<CategortFilterState> = _state

    private var initialList: List<CategoryFilterModel> = emptyList()



    fun getFilterCategory(c: String) {
        getFilterCategoryUseCase.getFilterCategory(c).observeForever { resource ->
            when (resource) {
                is Resource.Success -> {
                    initialList = resource.data ?: emptyList()
                    _state.value = CategortFilterState(
                        myCategoryFilterList = initialList,
                        isLoading = false
                    )
                    Log.d("CategoryFilterViewModel", "Data loaded successfully: ${initialList.size} items")
                }
                is Resource.Error -> {
                    _state.value = CategortFilterState(
                        error = "Error loading data: ${resource.message}",
                        isLoading = false
                    )
                    Log.e("CategoryFilterViewModel", "Error loading data: ${resource.message}")
                }
                is Resource.Loading -> {
                    _state.value = CategortFilterState(isLoading = true)
                }
            }
        }
    }

    fun search(query: String) {
        viewModelScope.launch(Dispatchers.Default) {
            val filteredList = if (query.isEmpty()) {
                initialList
            } else {
                initialList.filter { 
                    it.strMeal?.contains(query, ignoreCase = true) == true 
                }
            }

            _state.postValue(
                CategortFilterState(
                    myCategoryFilterList = filteredList,
                    isLoading = false
                )
            )
        }
    }
}
