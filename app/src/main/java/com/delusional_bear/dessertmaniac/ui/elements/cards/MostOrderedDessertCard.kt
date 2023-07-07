package com.delusional_bear.dessertmaniac.ui.elements.cards

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.ui.common_elements.DessertRating
import com.delusional_bear.dessertmaniac.ui.common_elements.HeartIcon
import com.delusional_bear.dessertmaniac.ui.common_functions.convertDoubleToCurrency
import com.delusional_bear.dessertmaniac.ui.elements.dialogs.DessertAlertDialog

@Composable
fun MostOrderedDessertCard(
    dessert: Dessert,
    modifier: Modifier = Modifier,
    onLikeButtonClick: () -> Unit = {},
    onAddToCartButtonClick: () -> Unit = {},
) {
    val openDialog = remember { mutableStateOf(false) }
    val context = LocalContext.current
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
    ) {
        Column(modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_small))) {
            Box(contentAlignment = Alignment.TopEnd) {
                AsyncImage(
                    model = dessert.dessertImageURL,
                    contentDescription = stringResource(id = dessert.dessertName),
                    modifier = Modifier.size(width = 250.dp, height = 200.dp),
                    contentScale = ContentScale.Crop,
                )
                HeartIcon(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(24.dp)
                ) {
                    onLikeButtonClick.invoke()
                    openDialog.value = true
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(
                    text = stringResource(id = dessert.dessertName),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                        .requiredWidthIn(max = 230.dp)
                        .padding(top = dimensionResource(id = R.dimen.padding_small)),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = convertDoubleToCurrency(dessert.price),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Medium,
                )
                Spacer(modifier = Modifier.height(4.dp))
                DessertRating(dessert = dessert)
                Spacer(modifier = Modifier.height(4.dp))
                Button(
                    onClick = { onAddToCartButtonClick.invoke() },
                    modifier = Modifier.fillMaxWidth(0.65f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.add_to_cart),
                        style = MaterialTheme.typography.titleSmall,
                    )
                }
            }
        }
        if (openDialog.value) DessertAlertDialog(dessert = dessert,
            onDialogDismiss = { openDialog.value = false },
            onConfirmClick = {
                openDialog.value = false
                Toast.makeText(context, R.string.toast_dessert_added_message, Toast.LENGTH_LONG)
                    .show()
            },
            onDismissClick = { openDialog.value = false },
            context = LocalContext.current
        )
    }
}