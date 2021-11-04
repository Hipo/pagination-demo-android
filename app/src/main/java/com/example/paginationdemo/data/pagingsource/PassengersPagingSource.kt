package com.example.paginationdemo.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Error
import androidx.paging.PagingSource.LoadResult.Page
import androidx.paging.PagingState
import com.example.paginationdemo.data.network.api.PassengerApi
import com.example.paginationdemo.data.network.response.PassengerResponse
import java.io.IOException
import retrofit2.HttpException

class PassengersPagingSource(
    private val passengerApi: PassengerApi,
) : PagingSource<Int, PassengerResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PassengerResponse> {
        var page = params.key ?: FIRST_PAGE_INDEX
        val size = params.loadSize
        return try {
            val passengersListResponse = passengerApi.getPassengers(page, size).body()
            val passengers = passengersListResponse?.data.orEmpty()
            val nextKey = if (passengers.isEmpty()) null else page.plus(1)
            val prevKey = if (page == FIRST_PAGE_INDEX) null else page.minus(1)
            Page(
                data = passengers,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            Error(exception)
        } catch (exception: HttpException) {
            Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PassengerResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.let { closestPage ->
                closestPage.prevKey?.plus(1) ?: closestPage.nextKey?.minus(1)
            }
        }
    }

    companion object {
        const val PASSENGERS_PAGE_SIZE = 5
        private const val FIRST_PAGE_INDEX = 0
    }
}
