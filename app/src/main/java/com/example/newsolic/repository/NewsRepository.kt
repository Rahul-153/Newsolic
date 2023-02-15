package com.example.newsolic.repository

import com.example.newsolic.api.RetrofitInstance
import com.example.newsolic.db.ArticleDatabase
import retrofit2.Retrofit

class NewsRepository(
    val db:ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode:String,page:Int)=
        RetrofitInstance.api.getBreakingNews(countryCode,page)

}