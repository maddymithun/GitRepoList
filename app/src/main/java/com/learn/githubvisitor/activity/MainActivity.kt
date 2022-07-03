package com.learn.githubvisitor.activity

import android.content.Context
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.navigation.NavController
import com.learn.githubvisitor.R
import com.learn.githubvisitor.databinding.ActivityMainBinding
import com.walton.eapp.view_model.ProgressBarHandleViewModel
import com.walton.eapp.view_model.ShowSnackBarViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    private val loadingBarViewModel: ProgressBarHandleViewModel by viewModels()

    private val showSnackBarViewModel: ShowSnackBarViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        loadingBarViewModel.titleUpdateLiveData.observe(this) {

            binding.toolbarTitle.text = it

        }
    }


}