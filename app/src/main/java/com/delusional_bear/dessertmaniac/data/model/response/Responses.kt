package com.delusional_bear.dessertmaniac.data.model.response

import com.google.gson.annotations.SerializedName

data class RecipesResponse(@SerializedName("results") val recipes: List<RecipeResponse>)

data class RecipeResponse(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String,
)