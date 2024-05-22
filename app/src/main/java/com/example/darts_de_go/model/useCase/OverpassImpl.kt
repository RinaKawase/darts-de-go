package com.example.darts_de_go.model.useCase

import com.example.darts_de_go.model.repository.OverpassService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OverpassImpl {
    private const val BASE_URL = "https://overpass-api.de"
    val gson = GsonBuilder()
        .serializeNulls()
        .create()

    // create Retrofit
    fun create(): OverpassService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(OverpassService::class.java)
    }
}