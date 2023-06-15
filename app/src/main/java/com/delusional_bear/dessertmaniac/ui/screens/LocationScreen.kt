package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Location
import com.delusional_bear.dessertmaniac.ui.elements.other.Map
import com.delusional_bear.dessertmaniac.ui.elements.cards.LocationCard
import com.google.android.gms.maps.model.LatLng

@Composable
fun LocationScreen(
    latLng: LatLng,
    locationList: List<Location>,
    modifier: Modifier = Modifier,
) {
    var latLong by remember { mutableStateOf(latLng) }
    Column(modifier = modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Map(latLng = latLong)
        LazyRow(
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.padding_small)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        ) {
            items(locationList) { location ->
                LocationCard(location = location) {
                    latLong = location.latLng
                }
            }
        }
    }
}