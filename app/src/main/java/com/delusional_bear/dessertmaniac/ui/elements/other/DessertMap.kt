package com.delusional_bear.dessertmaniac.ui.elements.other

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun Map(
    latLng: LatLng,
    modifier: Modifier = Modifier
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(latLng, 4.5f)
    }
    OutlinedCard(
        modifier = modifier
            .size(width = 400.dp, height = 550.dp)
            .padding(dimensionResource(id = R.dimen.padding_large)),
        elevation = CardDefaults.outlinedCardElevation(defaultElevation = 14.dp),
        shape = RoundedCornerShape(30.dp)
    ) {
        GoogleMap(
            modifier = modifier,
            cameraPositionState = cameraPositionState,
        ) {
            Marker(
                state = MarkerState(position = latLng),
                title = "Country",
                snippet = "Marker in Country"
            )
        }

    }
}