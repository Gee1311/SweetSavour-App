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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignOutDialog(
    modifier: Modifier = Modifier,
    uiState: SweetUiState,
    onClick: () -> Unit = {},
) {
    if (uiState.isSignOutDialogOpened) {
        AlertDialog(
            onDismissRequest = { onClick.invoke() }
        ) {
            Surface(
                modifier = modifier.wrapContentSize(),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(id = R.string.sign_out_text),
                        style = MaterialTheme.typography.displaySmall,
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(modifier = Modifier.align(Alignment.End)) {
                        TextButton(
                            onClick = { onClick.invoke() }
                        ) {
                            ButtonText(text = R.string.cancel)
                        }
                        TextButton(
                            onClick = { onClick.invoke() }
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