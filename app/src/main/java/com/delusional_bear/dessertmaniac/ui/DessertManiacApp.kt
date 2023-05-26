package com.delusional_bear.dessertmaniac.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.delusional_bear.dessertmaniac.data.DessertManiac
import com.delusional_bear.dessertmaniac.ui.screens.StartScreen

const val mainActivityLogcatTitle = "MainActivity"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DessertManiacApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()
    Scaffold(
        topBar = {
            DessertManiacTopAppBar()
        },
        content = { paddingValues ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues)
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
                            onAllClick = { navController.navigate(DessertManiac.All.name) }
                        )
                    }
                }
            }
        },
    )
}

