package com.delusional_bear.dessertmaniac.ui.elements.cards

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Location
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.elements.texts.ClosedOrOpenText
import com.delusional_bear.dessertmaniac.ui.elements.buttons.DirectionButton
import com.delusional_bear.dessertmaniac.ui.elements.buttons.LocationOptionButton
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun LocationCard(
    location: Location,
    modifier: Modifier = Modifier,
    onDirectionsClick: () -> Unit,
) {
    OutlinedCard(
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 4.dp,
        ),
        modifier = modifier.width(250.dp),
    ) {
        Column(modifier = modifier.padding(dimensionResource(id = R.dimen.padding_large))) {
            Column {
                Text(
                    text = stringResource(id = location.locationName),
                    style = MaterialTheme.typography.displaySmall,
                )
                Spacer(modifier = modifier.height(2.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.shop_rating, location.rating),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Normal,
                    )
                    Spacer(modifier = modifier.width(2.dp))
                    RatingBar(
                        value = location.rating.toFloat(),
                        style = RatingBarStyle.Fill(),
                        onValueChange = { },
                        onRatingChanged = { Log.d("TAG", "onRatingChanged: $it") },
                        size = 13.dp,
                        spaceBetween = 0.5.dp,
                    )
                    Spacer(modifier = modifier.width(2.dp))
                    Text(
                        text = "(${stringResource(id = R.string.shop_reviews, location.reviews)})",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Normal,
                    )
                }
                Spacer(modifier = modifier.height(2.dp))
                Text(
                    text = stringResource(id = location.locationAddress),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Normal,
                )
                Spacer(modifier = modifier.height(2.dp))
                ClosedOrOpenText(text = if (location.isClosed) R.string.closed else R.string.open)
                Spacer(modifier = modifier.height(2.dp))
                Text(
                    text = stringResource(id = R.string.schedule, location.opensAt, location.closesAt),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Normal,
                )
            }
            Spacer(modifier = modifier.height(8.dp))
            LazyRow(
                modifier = modifier.height(50.dp),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
            ) {
                item {
                    DirectionButton(onClick = onDirectionsClick)
                }
                items(DataSource.locationButtonContentList.drop(1)) { (icon, title) ->
                    LocationOptionButton(
                        icon = icon,
                        title = title,
                    ) {}
                }
            }
        }
    }
}
