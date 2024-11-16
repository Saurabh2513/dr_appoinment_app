package com.example.drappoinmentapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.drappoinmentapp.Model.DoctorsModel
import com.example.drappoinmentapp.Repository.MainRepository

class MainViewModel():ViewModel() {
    private val repository = MainRepository()
    fun loadDoctors() : LiveData<MutableList<DoctorsModel>> {
        return repository.load()

    }
}