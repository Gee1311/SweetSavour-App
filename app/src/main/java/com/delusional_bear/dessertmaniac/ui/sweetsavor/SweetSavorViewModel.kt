package com.delusional_bear.dessertmaniac.ui.sweetsavor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.data.model.SweetSavorRepository
import com.delusional_bear.dessertmaniac.data.model.response.RecipeResponse
import com.delusional_bear.dessertmaniac.ui.common_functions.totalPriceOfOrderedDesserts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SweetSavorViewModel(private val repository: SweetSavorRepository = SweetSavorRepository()): ViewModel() {
    fun getRecipes(): List<RecipeResponse> = repository.getRecipes()?.recipes.orEmpty()
    private val favoriteList: MutableSet<Dessert> = mutableSetOf()
    private val cartList: MutableSet<Dessert> = mutableSetOf()
    private val _uiState = MutableStateFlow(SweetUiState())
    val uiState: StateFlow<SweetUiState> = _uiState.asStateFlow()

    var moneyAmount by mutableStateOf("0")

    fun setMoneyToTopUp(money: String) {
        moneyAmount = money
    }

    fun updateUserBalance() {
        _uiState.update { currentState ->
            currentState.copy(
                balance = currentState.balance.plus(moneyAmount.toDouble())
            )
        }
    }

    fun setContinent(continent: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                continent = continent
            )
        }
    }

    fun changeSignOutDialogCondition() {
        _uiState.update { currentState ->
            currentState.copy(
                isSignOutDialogOpened = !currentState.isSignOutDialogOpened
            )
        }
    }

    fun addToFavorites(dessert: Dessert) {
        if (!favoriteList.contains(dessert)) {
            favoriteList.add(dessert)
        }
        _uiState.update { currentState ->
            currentState.copy(
                favoriteDesserts = favoriteList
            )
        }
    }

    fun addToCart(dessert: Dessert) {
        if (!cartList.contains(dessert)) {
            cartList.add(dessert)
        }
        _uiState.update { currentState ->
            currentState.copy(
                cartDesserts = cartList,
                totalItems = cartList.size,
                subTotal = totalPriceOfOrderedDesserts(cartList.toList()),
                discount =
                    if (cartList.size >= 5 && cartList.size % 5 == 0) currentState.subTotal * 0.01
                    else currentState.discount,
                shipping =
                    if (cartList.size == 0) 0.0
                    else if (currentState.totalItems > 0 && cartList.size % 5 == 0) currentState.shipping.plus(currentState.shipping)
                    else currentState.shipping,
            )
        }
    }

    fun plusDessert() {
        _uiState.update { currentState ->
            currentState.copy(
                dessertCount = currentState.dessertCount.inc()
            )
        }
    }

    fun minusDessert() {
        _uiState.update { currentState ->
            currentState.copy(
                dessertCount = if (currentState.dessertCount <= 0) 0 else currentState.dessertCount.dec()
            )
        }
    }
}