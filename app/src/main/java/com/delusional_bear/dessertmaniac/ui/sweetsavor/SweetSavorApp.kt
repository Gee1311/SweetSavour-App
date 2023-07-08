package com.delusional_bear.dessertmaniac.ui.sweetsavor

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.SweetSavor
import com.delusional_bear.dessertmaniac.data.model.DataSource.continentsList
import com.delusional_bear.dessertmaniac.data.model.DataSource.dessertList
import com.delusional_bear.dessertmaniac.ui.common_functions.cancelAndNavigateBack
import com.delusional_bear.dessertmaniac.ui.common_functions.displayToastMessage
import com.delusional_bear.dessertmaniac.ui.elements.other.SweetBottomAppBar
import com.delusional_bear.dessertmaniac.ui.elements.other.SweetTopAppBar
import com.delusional_bear.dessertmaniac.ui.screens.AvailableDessertsScreen
import com.delusional_bear.dessertmaniac.ui.screens.BalanceScreen
import com.delusional_bear.dessertmaniac.ui.screens.CartScreen
import com.delusional_bear.dessertmaniac.ui.screens.ContinentsScreen
import com.delusional_bear.dessertmaniac.ui.screens.CountriesScreen
import com.delusional_bear.dessertmaniac.ui.screens.FavoriteScreen
import com.delusional_bear.dessertmaniac.ui.screens.HomeScreen
import com.delusional_bear.dessertmaniac.ui.screens.ProfileScreen
import com.delusional_bear.dessertmaniac.ui.screens.TopUpBalanceScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SweetSavorApp(
    modifier: Modifier = Modifier,
    viewModel: SweetSavorViewModel = viewModel(),
) {
    val context = LocalContext.current
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val coroutineScope = rememberCoroutineScope()
    val uiState by viewModel.uiState.collectAsState()
    val currentScreenTitle = SweetSavor.valueOf(
        value = backStackEntry?.destination?.route ?: SweetSavor.Home.name
    )
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
                            uiState = uiState,
                            onDialogClick = { viewModel.changeSignOutDialogCondition() },
                            onBalanceButtonClick = { navController.navigate(SweetSavor.Balance.name) },
                            onPromotionButtonClick = { },
                            onSettingsButtonClick = { },
                            onBackPressed = { cancelAndNavigateBack(navController = navController) },
                            onOrderButtonClick = { navController.navigate(SweetSavor.Order.name) }
                        )
                    }
                    composable(route = SweetSavor.Desserts.name) {
                        AvailableDessertsScreen(
                            dessertList = dessertList,
                            onFavoriteClick = {
                                viewModel.addToFavorites(it)
                                displayToastMessage(
                                    context = context,
                                    R.string.toast_dessert_added_to_favorites_message,
                                    Toast.LENGTH_SHORT
                                )
                            },
                        ) {
                            coroutineScope.launch {
                                delay(500L)
                                viewModel.addToCart(it)
                                displayToastMessage(
                                    context = context,
                                    R.string.toast_dessert_added_to_cart_message,
                                    Toast.LENGTH_SHORT
                                )
                            }
                        }
                    }
                    composable(route = SweetSavor.Favorites.name) {
                        FavoriteScreen(
                            uiState = uiState,
                            onBackPressed = { cancelAndNavigateBack(navController = navController) },
                        )
                    }
                    composable(route = SweetSavor.Cart.name) {
                        CartScreen(
                            uiState = uiState,
                            viewModel = viewModel,
                            onBackPressed = { cancelAndNavigateBack(navController = navController) },
                        )
                    }
                    composable(route = SweetSavor.Balance.name) {
                        BalanceScreen(
                            uiState = uiState,
                            onTopUpCardClick = { navController.navigate(SweetSavor.TopUpBalance.name) }
                        )
                    }
                    composable(route = SweetSavor.TopUpBalance.name) {
                        TopUpBalanceScreen(
                            onMoneyAmountChange = { viewModel.setMoneyToTopUp(it) },
                            onConfirmButtonClick = { viewModel.updateUserBalance() },
                            moneyAmount = viewModel.moneyAmount,
                            onClick = { viewModel.setMoneyToTopUp(it.toString()) },
                            totalBalance = uiState.balance.toString()
                        )
                    }
                }
            }
        },
    )
}