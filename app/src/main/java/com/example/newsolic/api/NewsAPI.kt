package com.example.newsolic.api

import com.example.newsolic.models.NewsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY="4cdf110ac29a47deabe1b6ff17c3179e"
const val Base_URL="https://newsapi.org/"
interface NewsAPI {
    @GET("v2/top-headlines")
    fun getBreakingNews(
        @Query("country")
        countryCode: String="in",
        @Query("page")
        pageNumber: Int= 1,
        apikey : String=API_KEY
    ):Call<NewsResponse>
}
object NewsObj{
    val newsInstance: NewsAPI
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(NewsAPI::class.java)
    }
}

