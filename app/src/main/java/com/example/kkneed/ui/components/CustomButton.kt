package com.example.kkneed.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun CustomButton(
    modifier: Modifier,
    color: Color,
    textId: String,
    cornerRadius: Dp,
    gradient: Brush? = null,
    borderWidth: Dp = 0.dp,
    borderColor: Color = color,
    contentTextStyle: TextStyle,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(cornerRadius),
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 0.dp),
        border = BorderStroke(borderWidth, color = borderColor),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
        )
    ) {

        if (gradient == null) {

            Text(text = textId, style = contentTextStyle)
        } else {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush = gradient, shape =  RoundedCornerShape(cornerRadius))
                    .clip(RoundedCornerShape(cornerRadius))
                    , contentAlignment = Alignment.Center
            )
            {
                Text(
                    text =textId,
                    style = contentTextStyle
                )
            }

        }
    }
}

@Composable
fun BackButton(navController: NavController){
    IconButton(
        onClick = { navController.popBackStack() }
    ) {
        Icon(Icons.Outlined.ArrowBack, null)
    }
}