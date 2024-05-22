package com.example.darts_de_go.model.repository

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * OverService
 */
interface OverpassService {
    @GET("/api/interpreter")
    suspend fun queryCityNames(@Query("data")query: String):List<String>
}