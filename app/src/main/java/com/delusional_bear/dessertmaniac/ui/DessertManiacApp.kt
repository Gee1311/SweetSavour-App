package com.delusional_bear.dessertmaniac.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.DessertManiac
import com.delusional_bear.dessertmaniac.model.DataSource.countryList
import com.delusional_bear.dessertmaniac.model.DataSource.dessertList
import com.delusional_bear.dessertmaniac.model.DataSource.locationList
import com.delusional_bear.dessertmaniac.ui.elements.DessertManiacTopAppBar
import com.delusional_bear.dessertmaniac.ui.screens.AllScreen
import com.delusional_bear.dessertmaniac.ui.screens.CountryScreen
import com.delusional_bear.dessertmaniac.ui.screens.LocationScreen
import com.delusional_bear.dessertmaniac.ui.screens.StartScreen
import com.delusional_bear.dessertmaniac.ui.screens.TopMostPopularScreen
import com.delusional_bear.dessertmaniac.ui.screens.TopMostRatedScreen
import com.delusional_bear.dessertmaniac.ui.screens.TopWorstRatedScreen
import com.google.android.gms.maps.model.LatLng

@Composable
fun DessertManiacApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreenTitle = DessertManiac.valueOf(
        value = backStackEntry?.destination?.route ?: DessertManiac.Start.name
    )
    Scaffold(
        topBar = {
            DessertManiacTopAppBar(
                currentScreenTitle = currentScreenTitle,
                canNavigate = navController.previousBackStackEntry != null,
                onNavigateUp = { navController.navigateUp() }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = modifier.padding(paddingValues)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = DessertManiac.Start.name,
                    modifier = modifier
                ) {
                    composable(route = DessertManiac.Start.name) {
                        StartScreen(
                            onTopMostPopularClick = { navController.navigate(DessertManiac.TopMostPopular.name) },
                            onTopMostRatedClick = { navController.navigate(DessertManiac.TopMostRated.name) },
                            onTopWorstRatedClick = { navController.navigate(DessertManiac.TopWorstRated.name) },
                            onAllClick = { navController.navigate(DessertManiac.All.name) },
                            onSloganCardClick = { navController.navigate(DessertManiac.Country.name) },
                            modifier = modifier
                                .fillMaxSize()
                                .wrapContentHeight(Alignment.Bottom)
                                .padding(bottom = dimensionResource(id = R.dimen.padding_large))
                        )
                    }
                    composable(route = DessertManiac.TopMostPopular.name) {
                        TopMostPopularScreen(listOfDesserts = dessertList)
                    }
                    composable(route = DessertManiac.TopMostRated.name) {
                        TopMostRatedScreen(listOfDesserts = dessertList)
                    }
                    composable(route = DessertManiac.TopWorstRated.name) {
                        TopWorstRatedScreen(listOfDesserts = dessertList)
                    }
                    composable(route = DessertManiac.All.name) {
                        AllScreen(listOfDesserts = dessertList)
                    }
                    composable(route = DessertManiac.Country.name) {
                        CountryScreen(
                            countryList = countryList,
                            onUSClick = { navController.navigate(DessertManiac.UnitedStates.name) },
                            onUkraineClick = { navController.navigate(DessertManiac.Ukraine.name) },
                        )
                    }
                    composable(route = DessertManiac.UnitedStates.name) {
                        LocationScreen(
                            locationList = locationList
                                .takeLastWhile { it.country.countryName == R.string.united_states }
                                .sortedByDescending { it.rating },
                            latLng = LatLng(40.0863853295945, -101.42174663726917)
                        )
                    }
                    composable(route = DessertManiac.Ukraine.name) {
                        LocationScreen(
                            locationList = locationList
                                .takeWhile { it.country.countryName == R.string.ukraine }
                                .sortedByDescending { it.rating },
                            latLng = LatLng(49.042844722785375, 31.16778618532924)
                        )
                    }
                }
            }
        },
    )
}

