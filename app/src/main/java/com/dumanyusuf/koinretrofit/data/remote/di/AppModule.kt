package com.dumanyusuf.koinretrofit.data.remote.di

import com.dumanyusuf.koinretrofit.data.remote.MealApi
import com.dumanyusuf.koinretrofit.data.repo.RepoImpl
import com.dumanyusuf.koinretrofit.domain.repo.MealRepo
import com.dumanyusuf.koinretrofit.domain.use_case.get_category.GetCategoryUseCase
import com.dumanyusuf.koinretrofit.presentation.get_category.CategoryViewModel
import com.dumanyusuf.koinretrofit.util.Constans
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule= module {


    single {

        Retrofit.Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MealApi::class.java)
    }

    single {
        GetCategoryUseCase(get () )
    }

    viewModel {
        CategoryViewModel(get())
    }
    single<MealRepo> {
        RepoImpl(get())
    }

}