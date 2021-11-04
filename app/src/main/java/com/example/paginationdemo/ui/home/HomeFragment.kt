package com.example.paginationdemo.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.modelviewer.utils.viewbinding.viewBinding
import com.example.paginationdemo.R
import com.example.paginationdemo.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val homeViewModel by viewModels<HomeViewModel>()

    private val horizontalPassengersAdapter = HorizontalPassengersAdapter()
    private val verticalPassengersAdapter = VerticalPassengersAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            horizontalPassengersRecyclerView.adapter = horizontalPassengersAdapter
            verticalPassengersRecyclerView.adapter = verticalPassengersAdapter
        }
        getPassengers()
    }

    private fun getPassengers() {
        viewLifecycleOwner.lifecycleScope.launch {
            with(homeViewModel) {
                async {
                    getPassengers().collectLatest { horizontalPassengersAdapter.submitData(it) }
                }
                async {
                    getPassengers().collectLatest { verticalPassengersAdapter.submitData(it) }
                }
            }
        }
    }
}
