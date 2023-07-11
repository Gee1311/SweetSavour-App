package com.delusional_bear.dessertmaniac.ui.elements.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.common_functions.convertDoubleToCurrency
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun CartCard(
    dessert: Dessert,
    count: Int,
    modifier: Modifier = Modifier,
    onMinusButtonClick: () -> Unit = {},
    onPlusButtonClick: () -> Unit = {},
) {
    Card(
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = dessert.dessertImageURL,
                contentDescription = stringResource(id = dessert.dessertName),
                modifier = modifier
                    .clip(RoundedCornerShape(12.dp))
                    .size(100.dp),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = stringResource(id = dessert.dessertName),
                    modifier = Modifier.requiredWidthIn(max = 170.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = convertDoubleToCurrency(dessert.price),
                        style = MaterialTheme.typography.displaySmall,
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    ) {
                        OutlinedButton(
                            onClick = { onPlusButtonClick.invoke() },
                            modifier = Modifier.defaultMinSize(1.dp, 1.dp),
                            contentPadding = PaddingValues(2.dp),
                            shape = RoundedCornerShape(3.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                modifier = Modifier.padding(horizontal = 4.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = stringResource(id = R.string.count, count))
                        Spacer(modifier = Modifier.width(8.dp))
                        OutlinedButton(
                            onClick = { onMinusButtonClick.invoke() },
                            modifier = Modifier.defaultMinSize(1.dp, 1.dp),
                            contentPadding = PaddingValues(2.dp),
                            shape = RoundedCornerShape(3.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.remove_icon),
                                contentDescription = null,
                                modifier = Modifier.padding(horizontal = 4.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CartCardLightThemePreview() {
    DessertManiacTheme {
        CartCard(dessert = DataSource.dessertList.random(), count = 0)
    }
}

@Preview
@Composable
fun CartCardDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        CartCard(dessert = DataSource.dessertList.random(), count = 0)
    }
}