package com.walton.eapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import com.walton.eapp.view_model.LocationViewModel
import com.walton.eapp.view_model.ProgressBarHandleViewModel
import com.walton.eapp.view_model.ShowSnackBarViewModel
import com.walton.eapp.view_model.UpdateFirebaseTokenViewModel

typealias Inflate<Any> = (LayoutInflater, ViewGroup?, Boolean) -> Any

abstract class BaseFragmentWithBinding<VB : ViewBinding>(private val inflate: Inflate<VB>) :
    Fragment() {


    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    fun onLoadingVm(): ProgressBarHandleViewModel {
        val showLoadingVm: ProgressBarHandleViewModel by activityViewModels()
        return showLoadingVm
    }

    fun onSnackBarVm(): ShowSnackBarViewModel {
        val showSnackBar: ShowSnackBarViewModel by activityViewModels()
        return showSnackBar
    }

    fun onLocation(): LocationViewModel {
        val onLocationViewModel :LocationViewModel by activityViewModels()
        return onLocationViewModel
    }


    fun onUpdateFirebaseToken(): UpdateFirebaseTokenViewModel {
        val updateFirebaseTokenViewModel : UpdateFirebaseTokenViewModel by activityViewModels()
        return updateFirebaseTokenViewModel
    }

}