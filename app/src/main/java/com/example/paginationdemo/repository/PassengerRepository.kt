package com.example.paginationdemo.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.paginationdemo.data.network.api.PassengerApi
import com.example.paginationdemo.data.pagingsource.PassengersPagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PassengerRepository @Inject constructor(
    private val passengerApi: PassengerApi,
) {
    fun getPassengersPager() = Pager(
        config = PagingConfig(
            pageSize = PassengersPagingSource.PASSENGERS_PAGE_SIZE,
            initialLoadSize = PassengersPagingSource.PASSENGERS_PAGE_SIZE,
            enablePlaceholders = false,
        ),
        pagingSourceFactory = { PassengersPagingSource(passengerApi) }
    )
}
