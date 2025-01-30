package com.dumanyusuf.koinretrofit

import CategoryPageView
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.dumanyusuf.koinretrofit.domain.model.CategoryModel
import com.dumanyusuf.koinretrofit.presentation.get_category.CategoryViewModel
import com.dumanyusuf.koinretrofit.ui.theme.KoinRetrofitTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
   // private val categoryViewModel by viewModel<CategoryViewModel>()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinRetrofitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {

                   CategoryPageView()
                }
            }
        }
    }
}

