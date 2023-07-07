package com.delusional_bear.dessertmaniac.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.common_functions.convertDoubleToCurrency
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetUiState
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme
import com.delusional_bear.dessertmaniac.ui.theme.montserratAlternates

@Composable
fun BalanceScreen(
    uiState: SweetUiState,
    modifier: Modifier = Modifier,
    onTopUpCardClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_large))
    ) {
        Text(
            text = stringResource(id = R.string.your_balance),
            style = MaterialTheme.typography.displayLarge,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = convertDoubleToCurrency(uiState.balance),
            fontSize = 32.sp,
            fontFamily = montserratAlternates,
        )
        Spacer(modifier = Modifier.height(32.dp))
        BalanceOptionCard(
            optionIcon = R.drawable.forward_icon,
            optionTitle = R.string.send_money,
            modifier = Modifier.fillMaxWidth(),
            containerColor = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            BalanceOptionCard(
                optionIcon = R.drawable.top_up_icon,
                optionTitle = R.string.top_up_balance,
                modifier = Modifier.weight(1f, false),
                containerColor = MaterialTheme.colorScheme.secondary,
                onClick = { onTopUpCardClick.invoke() }
            )
            BalanceOptionCard(
                optionIcon = R.drawable.download_icon,
                optionTitle = R.string.withdraw_money,
                modifier = Modifier.weight(1f, false),
                containerColor = MaterialTheme.colorScheme.tertiary,
            )
        }
    }
}

@Composable
fun BalanceOptionCard(
    @DrawableRes optionIcon: Int,
    @StringRes optionTitle: Int,
    containerColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Card(
        modifier = modifier.clickable { onClick.invoke() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large))
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(MaterialTheme.colorScheme.onPrimaryContainer)
            ) {
                Icon(
                    painter = painterResource(id = optionIcon),
                    contentDescription = null,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = stringResource(id = optionTitle),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.width(90.dp)
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(MaterialTheme.colorScheme.onPrimaryContainer)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                    )
                }
            }
        }
    }
}