package com.example.newsolic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.RowScopeInstance.align
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.newsolic.api.NewsObj
import com.example.newsolic.db.ArticleDatabase
import com.example.newsolic.models.NewsResponse
import com.example.newsolic.repository.NewsRepository
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
                    previewScrollCard()
//                    UserCard()
//                    getNews()
                }
            }
        }
    }

//    private fun getNews() {
//        val news=NewsObj.newsInstance.getBreakingNews("in",1)
//        news.enqueue(object :retrofit2.Callback<NewsResponse>{
//            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
//                val news=response.body()
//                if(news!=null)
//                {
//                    Log.d("RAhul Rathore",news.toString())
//                }
//            }
//
//            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
//                Log.d("Rahul RAthore","Error in fetching news")
//            }
//
//        })
//    }
}

@Composable
fun UserCardScroll(){
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(24.dp)
            ){
        items(5) { index ->
            UserCard()
        }
    }
}


@Composable
fun UserCard(){
    Card(
        elevation = 4.dp,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.plane) , contentDescription = "Plane image")
        Box(
            modifier= Modifier
                .padding(horizontal = 10.dp)
                .height(250.dp)
//            contentAlignment = Alignment.BottomEnd
        ) {
            Column(
                modifier = Modifier.align(Alignment.BottomStart)
            ) {
                Text(
                    text = "Boeing dedicated 100 Million to Vicitims of crash",
                    fontSize = 20.sp,
                    modifier = Modifier
                )
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "CNN",
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(
                                start = 0.dp,
                                top = 0.dp,
                                end = 10.dp,
                                bottom = 0.dp
                            )
                            .align(CenterVertically)
                    )
                    Text(
                        text = "2019-07-11",
//                    modifier = Modifier.padding(12.dp)
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun previewCard(){
    UserCard()
}

@Preview
@Composable
fun previewScrollCard(){
    UserCardScroll()
}