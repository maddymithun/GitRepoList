package com.walton.eapp.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UpdateFirebaseTokenViewModel @Inject constructor() : ViewModel() {


    private val updateFirebaseTokenMutableData: MutableLiveData<Boolean> = MutableLiveData()
    val updateFirebaseTokenLiveData: LiveData<Boolean> get() = updateFirebaseTokenMutableData


    fun updateFirebaseToken(value: Boolean) {
        updateFirebaseTokenMutableData.value = value
    }


}