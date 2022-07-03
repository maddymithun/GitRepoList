package com.walton.eapp.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor() : ViewModel() {



    private val checkLocationPermissionMutableData: MutableLiveData<Boolean> = MutableLiveData()
    val checkLocationPermissionLiveData: LiveData<Boolean> get() = checkLocationPermissionMutableData


    private val removeLocUpdateMutableData: MutableLiveData<Boolean> = MutableLiveData()
    val removeLocUpdateLiveData: LiveData<Boolean> get() = removeLocUpdateMutableData



    fun checkLocationPermission(value: Boolean) {
        checkLocationPermissionMutableData.value = value
    }

    fun removeLocationUpdate(value: Boolean) {
        removeLocUpdateMutableData.value = value
    }




}