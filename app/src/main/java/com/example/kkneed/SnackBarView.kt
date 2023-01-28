package com.example.kkneed

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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