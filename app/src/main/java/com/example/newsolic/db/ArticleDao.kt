package com.example.newsolic.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsolic.models.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article):Long

    @Query("SELECT * FROM articles")
    fun getArticles():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}