package com.example.paginationdemo.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.example.paginationdemo.data.network.response.PassengerResponse

class PassengerDiffCallback : DiffUtil.ItemCallback<PassengerResponse>() {
    override fun areItemsTheSame(oldItem: PassengerResponse, newItem: PassengerResponse): Boolean {
        return oldItem._id == newItem._id
    }

    override fun areContentsTheSame(oldItem: PassengerResponse, newItem: PassengerResponse): Boolean {
        return oldItem == newItem
    }
}
