package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.common_elements.DescriptionText
import com.delusional_bear.dessertmaniac.ui.common_functions.convertDoubleToCurrency
import com.delusional_bear.dessertmaniac.ui.elements.dialogs.BalanceTopUpDialog
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TopUpBalanceScreen(
    modifier: Modifier = Modifier,
    moneyAmount: String,
    totalBalance: String,
    onMoneyAmountChange: (String) -> Unit,
    onConfirmButtonClick: () -> Unit,
    onClick: (Int) -> Unit,
) {
    var selectedAmount by remember { mutableStateOf("") }
    val openDialog = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_large))
    ) {
        DescriptionText(text = R.string.choose_top_up_amount)
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            OutlinedTextField(
                value = moneyAmount,
                onValueChange = onMoneyAmountChange,
                textStyle = MaterialTheme.typography.displaySmall,
                prefix = {
                    Icon(
                        painter = painterResource(id = R.drawable.dollar_icon),
                        contentDescription = null,
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                horizontalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = R.dimen.padding_small)
                ),
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = R.dimen.padding_small)
                ),
            ) {
                items(DataSource.balanceOptionsAmountList) { balanceOption ->
                    BalanceOptionAmount(
                        amount = balanceOption.toString(),
                        onClick = { onClick(balanceOption.toInt()) },
                        modifier = Modifier.selectable(
                            selected = selectedAmount == balanceOption.toString(),
                            onClick = {
                                selectedAmount = balanceOption.toString()
                                onClick(selectedAmount.toInt())
                            }
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    onConfirmButtonClick.invoke()
                    coroutineScope.launch {
                        delay(5000L)
                        openDialog.value = true
                    }
                },
                modifier = Modifier,
                shape = RoundedCornerShape(8.dp),
                enabled = selectedAmount.isNotEmpty() || moneyAmount != "0"
            ) {
                Text(
                    text = stringResource(id = R.string.confirm),
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        }
    }
    if (openDialog.value) {
        BalanceTopUpDialog(
            totalBalance = totalBalance.toDouble(),
            toppedUpBalance = moneyAmount.toDouble(),
            onDialogDismiss = { openDialog.value = false },
            onConfirmClick = { openDialog.value = false },
        )
    }
}

@Composable
fun BalanceOptionAmount(
    amount: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .size(width = 75.dp, height = 50.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = convertDoubleToCurrency(amount.toInt()),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            )
        }
    }
}