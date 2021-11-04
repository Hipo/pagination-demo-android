package com.example.paginationdemo.data.network.response

data class ListResponse<T>(
    val totalPassengers: Int?,
    val totalPages: Int?,
    val data: List<T>?
)
