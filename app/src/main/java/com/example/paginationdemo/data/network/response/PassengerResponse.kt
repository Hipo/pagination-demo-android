package com.example.paginationdemo.data.network.response

data class PassengerResponse(
    val _id: String?,
    val name: String?,
    val trips: String?,
    val airline: List<Airline?>?,
    val __v: String?,
)
