package com.android15dev.androidcompose.practice_views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android15dev.androidcompose.R

@Composable
fun StyledTextSample() {
    val fontFamily = FontFamily(
        Font(R.font.lexend_bold, weight = FontWeight.Bold),
        Font(R.font.lexend_extrabold, weight = FontWeight.ExtraBold),
        Font(R.font.lexend_light, weight = FontWeight.Light),
        Font(R.font.lexend_medium, weight = FontWeight.Medium),
        Font(R.font.lexend_regular, weight = FontWeight.Normal),
        Font(R.font.lexend_semibold, weight = FontWeight.SemiBold),
        Font(R.font.lexend_thin, weight = FontWeight.Thin)
    )

    Box(
        modifier = Modifier
            .background(Color(0xFF101010))
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Thin
                    )
                ) {
                    append("S")
                }
                append("ahil ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Thin
                    )
                ) {
                    append("G")
                }
                append("arg")
            },
            color = Color.White,
            fontSize = 25.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            /*textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                )
            ),*/
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Green)
                .padding(32.dp)
        )
    }
}