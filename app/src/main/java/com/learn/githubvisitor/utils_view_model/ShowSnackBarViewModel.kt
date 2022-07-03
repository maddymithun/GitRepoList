package com.walton.eapp.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowSnackBarViewModel @Inject constructor() : ViewModel() {

    private val showSnackBarMsg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val showSnackBarLivedata: LiveData<String> get() = showSnackBarMsg


    fun setMSg(msg: String) {
        showSnackBarMsg.value = msg
    }


}