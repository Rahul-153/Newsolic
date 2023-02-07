package com.example.newsolic

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.RowScopeInstance.align
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsolic.ui.theme.NewsolicTheme
import com.example.newsolic.ui.theme.backgroundColor
import com.example.newsolic.ui.theme.captionColor
import com.example.newsolic.ui.theme.textColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
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
                }
            }
        }
    }
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