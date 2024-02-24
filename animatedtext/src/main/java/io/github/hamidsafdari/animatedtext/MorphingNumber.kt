package io.github.hamidsafdari.animatedtext

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
fun MorphingNumber(
    number: Long,
    durationMillis: Long = 500,
    color: Color = Color.Black,
    style: DrawStyle = Stroke(5f)
) {
    val digits = number.toString(10).map { c ->
        when (c) {
            '1' -> Digit.ONE
            '2' -> Digit.TWO
            '3' -> Digit.THREE
            '4' -> Digit.FOUR
            '5' -> Digit.FIVE
            '6' -> Digit.SIX
            '7' -> Digit.SEVEN
            '8' -> Digit.EIGHT
            '9' -> Digit.NINE
            else -> Digit.ZERO
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
fun MorphingNumberPreview() {
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
            .height(110.dp),
        onClick = { count += 1 }
    ) {
        MorphingNumber(number = count)
    }
}