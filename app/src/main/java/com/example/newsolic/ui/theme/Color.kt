package com.example.newsolic.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Grey=Color(0xFF464646)
val white1=Color(0xFFf2f2f2)
val white2=Color(0xFFbababa)

val Colors.backgroundColor
    get() = if (isLight) Color.Black else Grey

val Colors.textColor
    get() = if(isLight) Color.White else white1

val Colors.captionColor
    get() = if (isLight) Color.White else white2