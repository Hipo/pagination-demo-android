package com.example.paginationdemo.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.paginationdemo.data.network.response.PassengerResponse
import com.example.paginationdemo.databinding.ItemPassengerCardBinding

class HorizontalPassengerViewHolder(
    private val binding: ItemPassengerCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(passengerResponse: PassengerResponse) {
        val airlineLogoURL = passengerResponse.airline?.get(0)?.logo
        val airlineName = passengerResponse.airline?.get(0)?.name
        val passengerName = passengerResponse.name
        val passengerTrip = passengerResponse.trips

        with(binding) {
            airlineLogoImageView.load(airlineLogoURL)
            airlineNameTextView.text = airlineName
            passengerNameTextView.text = passengerName
            passengerTripsTextView.text = passengerTrip
        }
    }

    companion object {
        fun create(parent: ViewGroup): HorizontalPassengerViewHolder {
            return HorizontalPassengerViewHolder(
                ItemPassengerCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }
}
