package com.android15dev.androidcompose.practice_views.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize

@Composable
fun ShowTimer() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val totalTimerCount = 100
        var currentAngle by remember {
            mutableStateOf(280f)
        }
        Arc(totalTimerCount, currentAngle)
        Button(onClick = {
            currentAngle -= (280 / totalTimerCount).toFloat()
        }) {
            Text(text = "Start")
        }
    }
}

@Composable
fun Arc(
    totalTime: Int,
    currentAngle: Float,
    modifier: Modifier = Modifier
) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }

    var value by remember {
        mutableStateOf(1f)
    }

    var currentTime by remember {
        mutableStateOf(totalTime)
    }

    var isTimerRunning by remember {
        mutableStateOf(false)
    }

    Box(modifier = modifier.onSizeChanged {
        size = it
    }) {
        Canvas(modifier = modifier) {
            drawArc(
                color = Color.Gray,
                startAngle = 130f,
                sweepAngle = 280f,
                useCenter = false,
                style = Stroke(width = 12f, cap = StrokeCap.Round),
                size = Size(size.width.toFloat(), size.height.toFloat())
            )

            drawArc(
                color = Color.Green,
                startAngle = 130f,
                sweepAngle = 280f * value,
                useCenter = false,
                style = Stroke(width = 12f, cap = StrokeCap.Round),
                size = Size(size.width.toFloat(), size.height.toFloat())
            )

            val center = Offset((size.width / 2).toFloat(), (size.height / 2).toFloat())
            val radius = size.width / 2f

            drawCircle(
                color = Color.Red,
                radius = 24f,
              //  center = Offset()
            )
        }
    }


}