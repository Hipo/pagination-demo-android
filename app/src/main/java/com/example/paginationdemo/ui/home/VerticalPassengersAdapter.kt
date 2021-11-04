package com.example.paginationdemo.ui.home

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.paginationdemo.data.network.response.PassengerResponse

class VerticalPassengersAdapter : PagingDataAdapter<PassengerResponse, VerticalPassengerViewHolder>(PassengerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalPassengerViewHolder {
        return VerticalPassengerViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: VerticalPassengerViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}
