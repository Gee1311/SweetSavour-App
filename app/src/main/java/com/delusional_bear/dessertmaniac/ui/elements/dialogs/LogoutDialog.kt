package com.delusional_bear.dessertmaniac.ui.elements.dialogs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogoutDialog(modifier: Modifier = Modifier) {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false }
        ) {
            Surface(
                modifier = modifier.wrapContentSize(),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(id = R.string.log_out_text),
                        style = MaterialTheme.typography.displaySmall,
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(modifier = Modifier.align(Alignment.End)) {
                        TextButton(
                            onClick = {
                                openDialog.value = false
                            }
                        ) {
                            ButtonText(text = R.string.cancel)
                        }
                        TextButton(
                            onClick = { openDialog.value = false }
                        ) {
                            ButtonText(text = R.string.confirm)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonText(
    text: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(id = text),
        style = MaterialTheme.typography.titleSmall,
        modifier = modifier
    )
}

@Preview
@Composable
private fun LogoutDialogLightThemePreview() {
    DessertManiacTheme {
        LogoutDialog()
    }
}

@Preview
@Composable
private fun LogoutDialogDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        LogoutDialog()
    }
}