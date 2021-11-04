package com.example.paginationdemo.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paginationdemo.data.network.response.PassengerResponse
import com.example.paginationdemo.repository.PassengerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val passengerRepository: PassengerRepository,
) : ViewModel() {

    fun getPassengers(): Flow<PagingData<PassengerResponse>> {
        return passengerRepository
            .getPassengersPager()
            .flow
            .cachedIn(viewModelScope)
    }
}
