package com.android15dev.androidcompose.practice_views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

/**
 * Change the State of the own component
 * */
@Composable
fun ChangeInternalStateSample() {
    SimpleColorBox(modifier = Modifier.fillMaxSize())
}

@Composable
fun SimpleColorBox(modifier: Modifier = Modifier) {
    val color = remember {
        mutableStateOf(Color.Yellow)
    }
    Box(
        modifier = modifier
            .background(color.value)
            .clickable {
                color.value = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
            }
    )
}


/**
 * Change the State of the other component
 * */
@Composable
fun ChangeExternalStateSample() {
    Row(modifier = Modifier.fillMaxSize()) {
        val color = remember {
            mutableStateOf(Color.Red)
        }
        ColorBox(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) { updatedColor ->
            color.value = updatedColor
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(color.value)
        )
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    callback: (Color) -> Unit
) {
    Box(
        modifier = modifier
            .background(Color.Cyan)
            .clickable {
                callback(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )
            }
    )
}