package com.hs.mrphcntr

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MorphingCounter(
    number: Long,
    durationMillis: Long = 500,
    color: Color = Color.Black,
    style: DrawStyle = Stroke(5f)
) {
    val digits = number.toString(10).map { c ->
        when (c) {
            '1' -> AnimatedDigit.ONE
            '2' -> AnimatedDigit.TWO
            '3' -> AnimatedDigit.THREE
            '4' -> AnimatedDigit.FOUR
            '5' -> AnimatedDigit.FIVE
            '6' -> AnimatedDigit.SIX
            '7' -> AnimatedDigit.SEVEN
            '8' -> AnimatedDigit.EIGHT
            '9' -> AnimatedDigit.NINE
            else -> AnimatedDigit.ZERO
        }
    }

    LazyRow(reverseLayout = true) {
        itemsIndexed(digits.reversed()) { _, item ->
            MorphingDigit(
                digit = item,
                modifier = Modifier.animateItemPlacement(),
                durationMillis = durationMillis,
                color = color,
                style = style
            )
        }
    }
}

@Preview
@Composable
fun MorphingCounterPreview() {
    var count by remember { mutableLongStateOf(1000) }
    LaunchedEffect(true) {
        for (i in 0 until 10) {
            count += 1
            delay(1000)
        }
    }

    Surface(
        modifier = Modifier
            .width(300.dp)
            .height(110.dp)
    ) {
        MorphingCounter(number = count)
    }
}