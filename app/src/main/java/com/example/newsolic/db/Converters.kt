package com.example.newsolic.db

import androidx.room.TypeConverter
import com.example.newsolic.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source):String{
        return source.name
    }

    @TypeConverter
    fun toSource(name:String): Source {
        return Source(name,name)
    }
}