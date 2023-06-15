package com.delusional_bear.dessertmaniac.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.SweetSavor
import com.delusional_bear.dessertmaniac.model.DataSource.continentsList
import com.delusional_bear.dessertmaniac.ui.elements.other.SweetTopAppBar
import com.delusional_bear.dessertmaniac.ui.screens.ContinentsScreen
import com.delusional_bear.dessertmaniac.ui.screens.CountriesScreen
import com.delusional_bear.dessertmaniac.ui.screens.ProfileScreen
import com.delusional_bear.dessertmaniac.ui.screens.StartScreen
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun SweetSavorApp(
    modifier: Modifier = Modifier,
    viewModel: SweetSavorViewModel = SweetSavorViewModel(),
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val uiState by viewModel.uiState.collectAsState()
    val currentScreenTitle = SweetSavor.valueOf(value = backStackEntry?.destination?.route ?: SweetSavor.Start.name)
    val context = LocalContext.current

    Scaffold(
        topBar = {
            SweetTopAppBar(
                currentScreenTitle = currentScreenTitle,
                canNavigate = navController.previousBackStackEntry != null,
                onNavigateUp = { navController.navigateUp() },
                onAvatarClickNavigation = { navController.navigate(SweetSavor.Profile.name) }
            )
        },
        content = { paddingValues ->
            Column(modifier = modifier.padding(paddingValues)) {
                NavHost(
                    navController = navController,
                    startDestination = SweetSavor.Start.name,
                    modifier = modifier,
                ) {
                    composable(route = SweetSavor.Start.name) {
                        StartScreen(
                            modifier = modifier
                                .fillMaxSize()
                                .wrapContentHeight(Alignment.Bottom)
                                .padding(bottom = dimensionResource(id = R.dimen.padding_large)),
                            onFABCLick = { navController.navigate(SweetSavor.Continent.name) },
                            sweetSavorViewModel = viewModel,
                            sweetUiState = uiState,
                        )
                    }
                    composable(route = SweetSavor.Continent.name) {
                        ContinentsScreen(
                            continentsList = continentsList.map { continent -> context.resources.getString(continent.continentName) },
                            onSelectedContinent = { viewModel.setContinent(it) },
                            onNextButtonClick = { navController.navigate(SweetSavor.Country.name) },
                            onCancelButtonClick = { cancelAndNavigateBack(navController = navController) }
                        )
                    }
                    composable(route = SweetSavor.Country.name) {
                        CountriesScreen(uiState)
                    }
                    composable(route = SweetSavor.Profile.name) {
                        ProfileScreen()
                    }
                }
            }
        },
    )
}

private fun cancelAndNavigateBack(navController: NavHostController) {
    navController.popBackStack(SweetSavor.Start.name, false)
}

@Preview
@Composable
private fun SweetSavorAppLightThemePreview() {
    SweetSavorApp()
}

@Preview
@Composable
private fun SweetSavorAppDarkThemePreview() {
    DessertManiacTheme {
        SweetSavorApp()
    }
}