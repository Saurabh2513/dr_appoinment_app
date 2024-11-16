package com.example.drappoinmentapp.Activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Visibility
import com.example.drappoinmentapp.Adapter.NearDoctorAdapter
import com.example.drappoinmentapp.ViewModel.MainViewModel
import com.example.drappoinmentapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private var viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNearByDoctor()
    }

    private fun initNearByDoctor() {
        binding.apply {
            progressBar.visibility = View.VISIBLE
            viewModel.loadDoctors().observe(this@MainActivity, Observer {
                topView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                topView.adapter = NearDoctorAdapter(it)
                progressBar.visibility = View.GONE
            })
        }
    }
}