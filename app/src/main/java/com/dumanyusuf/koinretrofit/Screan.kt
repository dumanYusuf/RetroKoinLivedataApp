package com.dumanyusuf.koinretrofit

sealed class Screan(val route:String) {


    object CategoryPageView:Screan("category")
    object CategoryFilterPageView:Screan("category_filter")


}