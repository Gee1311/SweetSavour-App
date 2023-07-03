package com.delusional_bear.dessertmaniac.data.model.api

import com.delusional_bear.dessertmaniac.data.model.response.RecipesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class RecipeWebService {
    private var api: RecipeAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(RecipeAPI::class.java)
    }

    fun getRecipes(): Call<RecipesResponse> {
        return api.getRecipes()
    }

    interface RecipeAPI {
        @GET("id")
        fun getRecipes(): Call<RecipesResponse>
    }
}