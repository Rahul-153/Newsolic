package com.example.newsolic.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newsolic.News
import com.example.newsolic.api.Resource
import com.example.newsolic.models.Article
import com.example.newsolic.models.NewsResponse

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewsView(
    countryCode:String,
    viewModel: NewsViewModel= androidx.lifecycle.viewmodel.compose.viewModel()
) {

    LaunchedEffect(Unit, block ={
        viewModel.getBreakingNews(countryCode)
    } )
    var newsState=viewModel.breakingNews.observeAsState().value!!
    var listOfArticles=newsState.data?.articles!!
    Scaffold(
        topBar = {
                Text(text = "Headlines")
        },
        content = {
            NewsContainer(articles = listOfArticles)
        }
    )
}

@Composable
fun NewsContainer(articles:List<Article>){
    LazyColumn {
        items(articles){
            article->
            UserCard(article=article)
        }
    }
}

@Composable
fun UserCard(article:Article){
    Card(
        elevation = 4.dp,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        AsyncImage(
            model = "https://example.com/image.jpg",
            contentDescription = null
        )
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
                        text = article.content,
                        fontSize = 20.sp,
                        modifier = Modifier
                    )
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = article.source.toString(),
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(
                                start = 0.dp,
                                top = 0.dp,
                                end = 10.dp,
                                bottom = 0.dp
                            )
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = article.publishedAt,
//                    modifier = Modifier.padding(12.dp)
                    )
                }
            }

        }
    }
}
