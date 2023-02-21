package com.example.newsolic

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.RowScopeInstance.align
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.newsolic.api.NewsObj
import com.example.newsolic.db.ArticleDatabase
import com.example.newsolic.models.NewsResponse
import com.example.newsolic.repository.NewsRepository
import com.example.newsolic.ui.NewsView
import com.example.newsolic.ui.NewsViewModel
import com.example.newsolic.ui.NewsViewModelProviderFactory
import com.example.newsolic.ui.theme.NewsolicTheme
import com.example.newsolic.ui.theme.backgroundColor
import retrofit2.Call
import retrofit2.Response

class MainActivity : ComponentActivity() {
    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        val newsRepository=NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory= NewsViewModelProviderFactory(newsRepository)
        viewModel=ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContent {
            NewsolicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.backgroundColor
                ) {
                    NewsView(countryCode = "in",viewModel=viewModel)
                }
            }
        }
    }
}