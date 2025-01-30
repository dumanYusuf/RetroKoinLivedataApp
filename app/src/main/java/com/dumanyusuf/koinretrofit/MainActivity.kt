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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dumanyusuf.koinretrofit.data.remote.dto.Category
import com.dumanyusuf.koinretrofit.domain.model.CategoryFilterModel
import com.dumanyusuf.koinretrofit.domain.model.CategoryModel
import com.dumanyusuf.koinretrofit.presentation.get_category.CategoryViewModel
import com.dumanyusuf.koinretrofit.presentation.get_filter_category.view.CategoryFilterPageView
import com.dumanyusuf.koinretrofit.ui.theme.KoinRetrofitTheme
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.net.URLDecoder

class MainActivity : ComponentActivity() {
   // private val categoryViewModel by viewModel<CategoryViewModel>()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinRetrofitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                  pageController()
                }
            }
        }
    }
}


@Composable
fun pageController() {
    val controller=rememberNavController()

    NavHost(navController = controller, startDestination = Screan.CategoryPageView.route){
        composable(Screan.CategoryPageView.route) {
           CategoryPageView(controller = controller)
        }
        composable(Screan.CategoryFilterPageView.route+"/{category}",
            arguments = listOf(
                navArgument("category"){type= NavType.StringType}
            )
        ) {
            val jsonMeal = it.arguments?.getString("category")
            val decodedJsonMeal = URLDecoder.decode(jsonMeal, "UTF-8")
            val mealObject = Gson().fromJson(decodedJsonMeal, CategoryModel::class.java)
              CategoryFilterPageView(category = mealObject)
        }
    }
}
