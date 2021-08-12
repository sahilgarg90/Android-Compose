package com.android15dev.androidcompose.practice_views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SampleColumn() {
    Column(
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello")
        Text(text = "Sahil")
    }
}

@Composable
fun CustomModifier() {
    Column(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.5f)
//                .width(250.dp)        // Change the width upto the screen maximum width
//                .requiredWidth(600.dp)      // Change the width beyond the screen maximum width
//                .padding(10.dp)       // Apply the padding to all directions
//                .padding(horizontal = 20.dp, vertical = 60.dp)
//                .padding(start = 20.dp, top = 40.dp, end = 60.dp, bottom = 80.dp)

    ) {
        Text(text = "Hello", modifier = Modifier.offset(x = 20.dp, y = 20.dp))
        ColumnSpacer(size = 30.dp)
        Text(text = "World!")
    }
}

@Composable
fun CustomModifier2() {
    Column(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.5f)
            .border(width = 10.dp, color = Color.Blue)
            .padding(20.dp)
            .border(10.dp, Color.Green, shape = CutCornerShape(5.dp))
            .padding(20.dp)
            .border(
                10.dp,
                Color.Cyan,
                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 20.dp,
                    bottomStart = 40.dp,
                    bottomEnd = 30.dp
                )
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Text(
            text = "Hello",
            color = Color.White,
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(text = "World!", modifier = Modifier.clickable {
            Log.i("TAG", "Clicked")
        })
    }
}