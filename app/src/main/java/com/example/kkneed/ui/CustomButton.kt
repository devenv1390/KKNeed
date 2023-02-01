package com.example.kkneed.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


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
        contentPadding = PaddingValues(vertical = 5.dp),
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
                    .fillMaxWidth()
                    .background(brush = gradient, shape =  RoundedCornerShape(cornerRadius))
                    .clip(RoundedCornerShape(cornerRadius))
                    .then(modifier.padding(vertical = 5.dp)), contentAlignment = Alignment.Center
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