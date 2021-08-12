package com.android15dev.androidcompose.practice_views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ShowConstraint(){
    val constraintSet = ConstraintSet {
        val greenView = createRefFor("green_view")
        val redView = createRefFor("red_view")

        val topView = createRefFor("top_view")

        val guideline = createGuidelineFromTop(30.dp)

        val barrier = createBottomBarrier(topView, margin = 70.dp)

        constrain(topView) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(50.dp)
        }

        constrain(greenView) {
            top.linkTo(guideline)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redView) {
            top.linkTo(barrier)
            start.linkTo(greenView.end)
            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        createHorizontalChain(greenView, redView, chainStyle = ChainStyle.Spread)
    }
    
    ConstraintLayout(constraintSet, modifier = Modifier.fillMaxSize()) {
        Box(Modifier.background(Color.Yellow).layoutId("top_view"))
        Box(Modifier.background(Color.Green).layoutId("green_view"))
        Box(Modifier.background(Color.Red).layoutId("red_view"))
    }
}