package com.example.paginationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.modelviewer.utils.viewbinding.viewBinding
import com.example.paginationdemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
