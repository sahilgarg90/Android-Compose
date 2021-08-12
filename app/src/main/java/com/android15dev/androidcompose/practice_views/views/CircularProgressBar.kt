package com.android15dev.androidcompose.practice_views

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ShowProgressBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressBar(
            percentage = 0.7f,
            maxNumber = 100
        )
    }
}

@Composable
fun CircularProgressBar(
    percentage: Float,
    maxNumber: Int,
    radius: Dp = 50.dp,
    progressWidth: Dp = 8.dp,
    progressColor: Color = Color.Blue,
    fontSize: TextUnit = 28.sp,
    animationDuration: Int = 1000,
    animationDelay: Int = 500
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val curPercentage by animateFloatAsState(
        targetValue = if (animationPlayed) {
            if (percentage <= 1f) percentage else 1f
        } else 0f,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        modifier = Modifier.size(radius * 2f),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawArc(
                color = progressColor,
                startAngle = -90f,
                sweepAngle = 360f * curPercentage,
                useCenter = false,
                style = Stroke(width = progressWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        Text(
            text = (curPercentage * maxNumber).toInt().toString(),
            fontWeight = FontWeight.Bold,
            fontSize = fontSize
        )
    }
}