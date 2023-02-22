package com.example.kkneed.ui.dialogs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.kkneed.R
import com.example.kkneed.ui.theme.BaseDP

@Composable
fun CameraRequiredDialog(
    onContinueClicked: () -> Unit,
    onExitClicked: () -> Unit
) {
    Dialog(
        onDismissRequest = onExitClicked,
        properties = DialogProperties(dismissOnClickOutside = false)
    ) {
        CameraRequiredContent(
            onContinueClicked = onContinueClicked,
            onExitClicked = onExitClicked
        )
    }
}

@Composable
private fun CameraRequiredContent(
    onContinueClicked: () -> Unit,
    onExitClicked: () -> Unit
) {
    Card {
        Column(
            verticalArrangement = Arrangement.spacedBy(BaseDP),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(BaseDP)
        ) {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.camera_required_message),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(BaseDP),
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedButton(
                    onClick = onExitClicked,
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colors.error
                    ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = MaterialTheme.colors.error
                    ),
                    modifier = Modifier.weight(0.5f)
                ) {
                    Text(
                        text = stringResource(id = R.string.camera_required_exit_btn),
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Button(
                    onClick = onContinueClicked,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White
                    ),
                    modifier = Modifier.weight(0.5f)
                ) {
                    Text(
                        text = stringResource(id = R.string.camera_required_continue_btn),
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}