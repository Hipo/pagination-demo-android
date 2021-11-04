package com.example.paginationdemo.ui.home

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.paginationdemo.data.network.response.PassengerResponse

class HorizontalPassengersAdapter : PagingDataAdapter<PassengerResponse, HorizontalPassengerViewHolder>(PassengerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalPassengerViewHolder {
        return HorizontalPassengerViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: HorizontalPassengerViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}
