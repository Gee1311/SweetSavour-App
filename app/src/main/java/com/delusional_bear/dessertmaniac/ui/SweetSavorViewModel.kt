package com.delusional_bear.dessertmaniac.ui

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusManager
import androidx.lifecycle.ViewModel
import com.delusional_bear.dessertmaniac.data.model.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SweetSavorViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(SweetUiState())
    val uiState: StateFlow<SweetUiState> = _uiState.asStateFlow()

    var dessertName by mutableStateOf("")

    fun setContinent(continent: String) {
        _uiState.update { currentState ->
            currentState.copy(
                continent = continent
            )
        }
    }

    fun inputDessertName(name: String) {
        dessertName = name
    }

    fun checkAvailability(
        focusManager: FocusManager,
        context: Context
    ) {
        DataSource.dessertList.forEach { dessert ->
            if (context.resources.getString(dessert.dessertName).equals(dessertName, ignoreCase = true)) {
                _uiState.update { currentState ->
                    currentState.copy(
                        isDessertAvailable = true
                    )
                }
            }
        }
        focusManager.clearFocus()
        inputDessertName("")
    }
}