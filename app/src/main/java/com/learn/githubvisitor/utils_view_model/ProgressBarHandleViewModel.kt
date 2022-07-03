package com.walton.eapp.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProgressBarHandleViewModel @Inject constructor() : ViewModel() {

    private val showLoadingMutableData: MutableLiveData<Boolean> = MutableLiveData()
    val showLoadingLiveData: LiveData<Boolean> get() = showLoadingMutableData


    private val titleUpdateMutableData: MutableLiveData<String> = MutableLiveData()
    val titleUpdateLiveData: LiveData<String> get() = titleUpdateMutableData

    fun showLoadingFun(value: Boolean) {
        showLoadingMutableData.postValue(value)
    }
    fun updateToolbar(value: String) {
        titleUpdateMutableData.value = value
    }


}