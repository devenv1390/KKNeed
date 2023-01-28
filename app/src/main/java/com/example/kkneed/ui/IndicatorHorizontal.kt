package com.example.kkneed.ui

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun IndicatorHorizontal(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if(isSelected) 30.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
    )
    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(if(isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary)
    )
}