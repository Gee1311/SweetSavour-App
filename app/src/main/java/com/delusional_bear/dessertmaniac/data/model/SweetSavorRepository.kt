package com.delusional_bear.dessertmaniac.data.model

import com.delusional_bear.dessertmaniac.data.model.api.RecipeWebService
import com.delusional_bear.dessertmaniac.data.model.response.RecipesResponse

class SweetSavorRepository(private val recipeWebService: RecipeWebService = RecipeWebService()) {
    fun getRecipes(): RecipesResponse? = recipeWebService.getRecipes().execute().body()
}