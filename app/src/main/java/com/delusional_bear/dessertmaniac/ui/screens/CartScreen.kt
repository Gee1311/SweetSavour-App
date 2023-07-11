package com.delusional_bear.dessertmaniac.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.ui.common_elements.DescriptionText
import com.delusional_bear.dessertmaniac.ui.common_functions.convertDoubleToCurrency
import com.delusional_bear.dessertmaniac.ui.common_functions.totalPriceOfOrderedDesserts
import com.delusional_bear.dessertmaniac.ui.elements.cards.CartCard
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetUiState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    uiState: SweetUiState,
    paymentMethods: List<Pair<Int, Int>>,
    deliveryDestination: String,
    subTotal: Double,
    dessertsNumberToOrder: Int,
    shipping: Double,
    discount: Double,
    dessertCount: Int,
    modifier: Modifier = Modifier,
    onMinusButtonClick: () -> Unit = {},
    onPlusButtonClick: () -> Unit = {},
    onPaymentMethodClick: (Int) -> Unit = {},
    onConfirmButtonClick: () -> Unit = {},
    onDeliveryDestinationChange: (String) -> Unit = {},
    onBackPressed: () -> Unit = {},
) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            initialValue = SheetValue.Hidden,
            skipPartiallyExpanded = false,
        )
    )
    val coroutineScope = rememberCoroutineScope()
    BackHandler { onBackPressed.invoke() }
    BottomSheetScaffold(
        sheetContent = {
            CartBottomSheet(
                paymentMethods = paymentMethods,
                deliveryDestination = deliveryDestination,
                onPaymentMethodClick = onPaymentMethodClick,
                onConfirmButtonClick = {
                    coroutineScope.launch {
                        bottomSheetScaffoldState.bottomSheetState.hide()
                        onConfirmButtonClick()
                    }
                }
            ) {
                onDeliveryDestinationChange(it)
            }
        },
        scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = 40.dp,
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_large))
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
                modifier = Modifier.height(370.dp)
            ) {
                items(uiState.cartDesserts.toList()) { dessert ->
                    CartCard(
                        dessert = dessert,
                        count = dessertCount,
                        onMinusButtonClick = { onMinusButtonClick() },
                        onPlusButtonClick = { onPlusButtonClick() },
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            OrderPrice(
                text = R.string.sub_total_text,
                price = convertDoubleToCurrency(subTotal)
            )
            Spacer(modifier = Modifier.height(12.dp))
            OrderPrice(
                text = R.string.shipping_text,
                price = convertDoubleToCurrency(
                    if (dessertsNumberToOrder > 0) shipping else 0.0
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            OrderPrice(
                text = R.string.discount,
                price = convertDoubleToCurrency(discount)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Divider(thickness = 2.dp)
            Spacer(modifier = Modifier.height(16.dp))
            TotalPrice(uiState = uiState) {
                coroutineScope.launch {
                    if (!bottomSheetScaffoldState.bottomSheetState.isVisible)
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    else
                        bottomSheetScaffoldState.bottomSheetState.partialExpand()
                }
            }
        }
    }
}

@Composable
private fun CartBottomSheet(
    paymentMethods: List<Pair<Int, Int>>,
    deliveryDestination: String,
    modifier: Modifier = Modifier,
    onPaymentMethodClick: (Int) -> Unit = {},
    onConfirmButtonClick: () -> Unit = {},
    onDeliveryDestinationChange: (String) -> Unit = {},
) {
    var selectedPaymentMethod by remember { mutableStateOf(0) }
    Column(
        modifier = modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.6f)
            .padding(dimensionResource(id = R.dimen.padding_large)),
    ) {
        DescriptionText(
            text = R.string.delivery_option,
            textAlign = TextAlign.Start,
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = deliveryDestination,
            onValueChange = onDeliveryDestinationChange,
            modifier = Modifier.fillMaxWidth(1f),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.enter_location),
                    style = MaterialTheme.typography.titleSmall,
                )
            },
            textStyle = MaterialTheme.typography.titleSmall,
        )
        Spacer(modifier = Modifier.height(8.dp))
        DescriptionText(
            text = R.string.payment_method,
            textAlign = TextAlign.Start,
        )
        Column {
            paymentMethods.forEach { paymentMethod ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Icon(
                            painter = painterResource(id = paymentMethod.second),
                            contentDescription = null,
                        )
                        Text(
                            text = stringResource(id = paymentMethod.first),
                            style = MaterialTheme.typography.titleSmall,
                        )
                    }
                    RadioButton(
                        selected = selectedPaymentMethod == paymentMethod.first,
                        onClick = {
                            selectedPaymentMethod = paymentMethod.first
                            onPaymentMethodClick(selectedPaymentMethod)
                        },
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onConfirmButtonClick,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(12.dp),
            enabled = selectedPaymentMethod != 0
        ) {
            Text(
                text = stringResource(id = R.string.confirm),
                style = MaterialTheme.typography.displaySmall,
            )
        }
    }
}

@Composable
private fun OrderPrice(
    text: Int,
    price: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.labelMedium,
        )
        Text(
            text = stringResource(id = R.string.shipping_price, price),
            style = MaterialTheme.typography.displaySmall,
        )
    }
}

@Composable
private fun TotalPrice(
    uiState: SweetUiState,
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit = {},
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .clickable { onCardClick() },
        shape = RoundedCornerShape(10.dp),
    ) {
        Box {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(
                        id = R.string.total_text,
                        uiState.totalItems
                    ),
                    style = MaterialTheme.typography.labelMedium,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(
                        id = R.string.total_price,
                        convertDoubleToCurrency(
                            displayTotalPriceForOrder(
                                uiState.cartDesserts.toList(),
                                uiState.shipping,
                                uiState.discount
                            )
                        )
                    ),
                    style = MaterialTheme.typography.displayMedium,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(id = R.string.confirm_order),
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

private fun displayTotalPriceForOrder(
    dessertList: List<Dessert>,
    shipping: Double,
    discount: Double,
): Double {
    var totalPrice = totalPriceOfOrderedDesserts(dessertList)
    if (dessertList.isNotEmpty()) totalPrice += shipping
    if (dessertList.size >= 10 && dessertList.size % 5 == 0) totalPrice -= discount
    return totalPrice
}