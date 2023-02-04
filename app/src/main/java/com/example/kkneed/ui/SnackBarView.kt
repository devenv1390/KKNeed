package com.example.kkneed.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kkneed.ui.components.IconTextField
import com.example.kkneed.ui.theme.KKNeedTheme

@Composable
fun MySnackBar(snackbarHostState: SnackbarHostState, onDismiss: () -> Unit) {
    SnackbarHost(hostState = snackbarHostState, snackbar = { data ->
        Snackbar(modifier = Modifier.padding(12.dp), action = {
            data.actionLabel?.let {
                TextButton(onClick = { onDismiss }) {
                    Text(text = it)
                }
            }
        }) {
            Text(text = data.message)
        }
    })
}
@Composable
@Preview
fun SnackBarPreview() {
    KKNeedTheme() {

    }
}