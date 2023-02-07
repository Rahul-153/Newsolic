package com.example.newsolic

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "News")
data class News(var caption: String, var source :String, var date: String, var image : String,@PrimaryKey(autoGenerate = true) var id: Int){

}
