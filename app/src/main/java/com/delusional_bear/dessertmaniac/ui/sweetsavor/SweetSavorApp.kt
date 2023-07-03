package com.delusional_bear.dessertmaniac.ui.sweetsavor

//import com.delusional_bear.dessertmaniac.ui.screens.FavoriteScreen
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.SweetSavor
import com.delusional_bear.dessertmaniac.data.model.DataSource.continentsList
import com.delusional_bear.dessertmaniac.data.model.DataSource.dessertList
import com.delusional_bear.dessertmaniac.ui.elements.other.SweetBottomAppBar
import com.delusional_bear.dessertmaniac.ui.elements.other.SweetTopAppBar
import com.delusional_bear.dessertmaniac.ui.screens.AvailableDessertsScreen
import com.delusional_bear.dessertmaniac.ui.screens.CartScreen
import com.delusional_bear.dessertmaniac.ui.screens.ContinentsScreen
import com.delusional_bear.dessertmaniac.ui.screens.CountriesScreen
import com.delusional_bear.dessertmaniac.ui.screens.FavoriteScreen
import com.delusional_bear.dessertmaniac.ui.screens.HomeScreen
import com.delusional_bear.dessertmaniac.ui.screens.ProfileScreen
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun SweetSavorApp(
    modifier: Modifier = Modifier,
    viewModel: SweetSavorViewModel = viewModel(),
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val uiState by viewModel.uiState.collectAsState()
    val currentScreenTitle = SweetSavor.valueOf(
        value = backStackEntry?.destination?.route ?: SweetSavor.Home.name
    )
    val context = LocalContext.current

    // recipes
//    val recipes = viewModel.getRecipes()

    Scaffold(
        topBar = {
            SweetTopAppBar(
                currentScreenTitle = currentScreenTitle,
                canNavigate = navController.previousBackStackEntry != null,
                onNavigateUp = { navController.navigateUp() },
                onProfileClicked = { navController.navigate(SweetSavor.Profile.name) }
            )
        },
        bottomBar = {
            SweetBottomAppBar(
                onOrderClicked = { navController.navigate(SweetSavor.Continent.name) },
                onListOfDessertsClicked = { navController.navigate(SweetSavor.Desserts.name) },
                onHomeClicked = { navController.navigate(SweetSavor.Home.name) },
                onFavoritesClicked = { navController.navigate(SweetSavor.Favorites.name) },
                onCartClicked = { navController.navigate(SweetSavor.Cart.name) }
            )
        },
        content = { paddingValues ->
            Column(modifier = modifier.padding(paddingValues)) {
                NavHost(
                    navController = navController,
                    startDestination = SweetSavor.Home.name,
                    modifier = modifier,
                ) {
                    composable(route = SweetSavor.Home.name) {
                        HomeScreen(
                            modifier = modifier
                                .fillMaxSize()
                                .wrapContentHeight(Alignment.Bottom)
                                .padding(bottom = dimensionResource(id = R.dimen.padding_large)),
                            sweetSavorViewModel = viewModel,
                            sweetUiState = uiState,
                        )
                    }
                    composable(route = SweetSavor.Continent.name) {
                        ContinentsScreen(
                            continentsList = continentsList,
                            onSelectedContinent = { viewModel.setContinent(it) },
                            onNextButtonClick = { navController.navigate(SweetSavor.Country.name) },
                            onCancelButtonClick = { cancelAndNavigateBack(navController = navController) },
                        )
                    }
                    composable(route = SweetSavor.Country.name) {
                        CountriesScreen(uiState)
                    }
                    composable(route = SweetSavor.Profile.name) {
                        ProfileScreen(
                            viewModel = viewModel,
                            uiState = uiState,
                        )
                    }
                    composable(route = SweetSavor.Desserts.name) {
                        AvailableDessertsScreen(
                            listOfDesserts = dessertList,
                            viewModel = viewModel,
                        )
                    }
                    composable(route = SweetSavor.Favorites.name) {
                        FavoriteScreen(uiState = uiState)
                    }
                    composable(route = SweetSavor.Cart.name) {
                        CartScreen(
                            uiState = uiState,
                            viewModel = viewModel
                        )
                    }
                    // FIXME: Fix navigation issue from ProfileScreen to another 
                    /*composable(
                        route = SweetSavor.PersonalData.name + "/{optionNumber}",
                        arguments = listOf(navArgument("optionNumber") {
                            type = NavType.IntType
                        })
                    ) { backStackEntry ->
                        PersonalDataScreen(viewModel = viewModel)
                    }*/
                }
            }
        },
    )
}

private fun cancelAndNavigateBack(navController: NavHostController) {
    navController.popBackStack(SweetSavor.Home.name, false)
}

@Preview
@Composable
private fun SweetSavorAppLightThemePreview() {
    DessertManiacTheme {
        SweetSavorApp()
    }
}

@Preview
@Composable
private fun SweetSavorAppDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        SweetSavorApp()
    }
}