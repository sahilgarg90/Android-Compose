package com.android15dev.androidcompose.practice_views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SampleRow() {
    Row(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Hello")
        Text(text = "Sahil")
    }
}

@Composable
fun SampleRowWIthCustomSize() {
    Row(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth(0.8f)
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Hello")
        Text(text = "Sahil")
    }
}