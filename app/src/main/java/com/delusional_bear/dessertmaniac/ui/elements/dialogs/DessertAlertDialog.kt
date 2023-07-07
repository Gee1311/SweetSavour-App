package com.delusional_bear.dessertmaniac.ui.elements.dialogs

import android.content.Context
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert

@Composable
fun DessertAlertDialog(
    modifier: Modifier = Modifier,
    context: Context,
    dessert: Dessert,
    onDialogDismiss: () -> Unit = {},
    onConfirmClick: () -> Unit = {},
    onDismissClick: () -> Unit = {},
) {
    AlertDialog(
        onDismissRequest = onDialogDismiss,
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
        modifier = modifier,
        text = {
            Text(
                text = stringResource(
                    id = R.string.dessert_added,
                    context.resources.getString(dessert.dessertName)
                ),
                style = MaterialTheme.typography.titleSmall,
                lineHeight = 24.sp,
            )
        }
    )
}