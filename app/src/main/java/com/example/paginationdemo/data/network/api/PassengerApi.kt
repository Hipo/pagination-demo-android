package com.example.paginationdemo.data.network.api

import com.example.paginationdemo.data.network.response.ListResponse
import com.example.paginationdemo.data.network.response.PassengerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PassengerApi {
    @GET("passenger")
    suspend fun getPassengers(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<ListResponse<PassengerResponse>>
}
