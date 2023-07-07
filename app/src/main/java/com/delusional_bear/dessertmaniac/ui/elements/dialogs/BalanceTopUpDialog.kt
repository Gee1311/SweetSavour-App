package com.delusional_bear.dessertmaniac.ui.elements.dialogs

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.common_functions.convertDoubleToCurrency

@Composable
fun BalanceTopUpDialog(
    totalBalance: Double,
    toppedUpBalance: Double,
    modifier: Modifier = Modifier,
    onDialogDismiss: () -> Unit = {},
    onConfirmClick: () -> Unit = {},
    onDismissClick: () -> Unit = {},
) {
    AlertDialog(
        onDismissRequest = { onDialogDismiss.invoke() },
        confirmButton = {
            Button(
                onClick = { onConfirmClick.invoke() },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.confirm),
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        },
        dismissButton = {
            Button(
                onClick = { onDismissClick.invoke() },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.cancel),
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        },
        title = {
            Text(
                text = stringResource(id = R.string.top_up_dialog_title),
                style = MaterialTheme.typography.displaySmall,
            )
        },
        text = {
            Text(
                text = stringResource(
                    id = R.string.top_up_dialog_text,
                    convertDoubleToCurrency(toppedUpBalance),
                    convertDoubleToCurrency(totalBalance)
                ),
                style = MaterialTheme.typography.titleSmall,
            )
        },
        modifier = modifier,
    )
}