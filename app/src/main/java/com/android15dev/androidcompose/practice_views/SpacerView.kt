package com.android15dev.androidcompose.practice_views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp


/**
 * Used to add some space between elements
 * */

@Composable
fun ColumnSpacer(size: Dp) {
    Spacer(modifier = Modifier.height(size))
}
