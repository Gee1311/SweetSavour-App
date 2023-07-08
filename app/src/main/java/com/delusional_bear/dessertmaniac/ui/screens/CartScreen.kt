package com.delusional_bear.dessertmaniac.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.ui.common_elements.DescriptionText
import com.delusional_bear.dessertmaniac.ui.common_functions.convertDoubleToCurrency
import com.delusional_bear.dessertmaniac.ui.common_functions.totalPriceOfOrderedDesserts
import com.delusional_bear.dessertmaniac.ui.elements.cards.CartCard
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetSavorViewModel
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    uiState: SweetUiState,
    viewModel: SweetSavorViewModel,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit = {},
) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            initialValue = SheetValue.PartiallyExpanded,
            skipPartiallyExpanded = false,
        )
    )
    BackHandler { onBackPressed.invoke() }
    BottomSheetScaffold(
        sheetContent = { CartBottomSheet() },
        scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = 30.dp,
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
                        count = uiState.dessertCount,
                        onMinusButtonClick = { viewModel.minusDessert() },
                        onAddButtonClick = { viewModel.plusDessert() },
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            OrderPrice(
                text = R.string.sub_total_text,
                price = convertDoubleToCurrency(uiState.subTotal)
            )
            Spacer(modifier = Modifier.height(12.dp))
            OrderPrice(
                text = R.string.shipping_text,
                price = convertDoubleToCurrency(
                    if (uiState.cartDesserts.size > 0) uiState.shipping else 0.0
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            OrderPrice(
                text = R.string.discount,
                price = convertDoubleToCurrency(uiState.discount)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Divider(thickness = 2.dp)
            Spacer(modifier = Modifier.height(16.dp))
            TotalPrice(uiState = uiState)
        }
    }
}

// TODO: To change CartBottomSheet so that user can choose whether an order must be delivered to home, when they want to pick up the dessert, payment methods etc.

@Composable
private fun CartBottomSheet(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.55f)
            .padding(dimensionResource(id = R.dimen.padding_large)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DescriptionText(text = R.string.payment_method)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        ) {
            val paymentOptions = listOf(
                R.drawable.paypal,
                R.drawable.google,
                R.drawable.apple,
            )
            items(paymentOptions) { payment ->
                Image(
                    painter = painterResource(id = payment),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
            }
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
) {
    Card(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(10.dp),
    ) {
        Box(contentAlignment = Alignment.Center) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.total_text,
                            uiState.totalItems
                        ),
                        style = MaterialTheme.typography.labelMedium,
                    )
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
                }
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