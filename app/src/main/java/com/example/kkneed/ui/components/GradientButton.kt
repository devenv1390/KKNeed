package com.example.kkneed.ui

import androidx.annotation.StringRes
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kkneed.ui.theme.KKNeedTheme

@Composable
fun GradientButton(
    modifier: Modifier,
    textId: String,
    onClick: () -> Unit,
) {

    val gradient = Brush.horizontalGradient(
        listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.inversePrimary
        )
    )

    CustomButton(
        onClick = onClick,
        modifier = modifier,
        gradient = gradient,
        color = Color.Transparent,
        cornerRadius = 50.dp,
        textId = textId,
        contentTextStyle = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
    )
}
@Composable
fun DeleteButton(color1: Color, onClick: () -> Unit) {
    val colorAnimation1 by rememberInfiniteTransition().animateColor(
        initialValue = color1.copy(alpha = 0.35f),
        targetValue = color1.copy(alpha = 0.75f),
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(
                durationMillis = 4750 + 500 * color1.alpha.toInt(),
                easing = FastOutLinearInEasing,
                delayMillis = 2730 * color1.alpha.toInt()
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    
    Card(
        modifier = Modifier
            .padding(start = 10.dp, top = 20.dp, end = 10.dp)
            .height(200.dp)
            .width(175.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        IconButton(onClick = onClick) {
            Canvas(modifier = Modifier
                .padding(start = 10.dp, top = 40.dp, end = 10.dp)
                .height(170.dp)
                .width(175.dp), onDraw = {
                //渐变色块
                drawCircle(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorAnimation1,
                            Color.Blue
                        ),
                        start = Offset(0f,0f),end = Offset(400.dp.value,400.dp.value),
                    ),
                    radius = 300.dp.value,
                    center = Offset(x = size.width / 2, y = size.height / 2)
                )
            })
        }
    }
}
@Composable
fun test(){
    val infiniteTransition = rememberInfiniteTransition()
    val size by infiniteTransition.animateValue(
        initialValue = 100.dp,
        targetValue = 200.dp,
        typeConverter = TwoWayConverter({ AnimationVector1D(it.value) }, { it.value.dp }),
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        Modifier
            .size(size)
            .padding(20.dp)
            .alpha(alpha)
            .background(Color.Red)
    )
}
@Preview
@Composable
fun GradientPreview(){
    KKNeedTheme {
        DeleteButton(color1 = MaterialTheme.colorScheme.primary) {
            
        }
    }
}
