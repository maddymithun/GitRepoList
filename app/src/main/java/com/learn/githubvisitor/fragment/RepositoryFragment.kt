package com.learn.githubvisitor.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.example.GithubDetails
import com.example.example.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learn.githubvisitor.R
import com.learn.githubvisitor.adapter.RepositoryAdapter
import com.learn.githubvisitor.config.CheckNetworkStatus
import com.learn.githubvisitor.databinding.FragmentRepositoryBinding
import com.learn.githubvisitor.utils.SendData
import com.learn.githubvisitor.viewModel.RepositoryViewModel
import com.walton.eapp.base.BaseFragmentWithBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.Type
import javax.inject.Inject

@AndroidEntryPoint
class RepositoryFragment @Inject constructor() :
    BaseFragmentWithBinding<FragmentRepositoryBinding>(FragmentRepositoryBinding::inflate) ,SendData{
    val repolistViewModel: RepositoryViewModel by viewModels()
    val gson = Gson()
     var githubDetails= listOf<GithubDetails>()
    @Inject
    lateinit var adapter: RepositoryAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoadingVm().updateToolbar("Repository List")
        CheckNetworkStatus.isOnline(requireContext(), object : CheckNetworkStatus.Status {
            override fun online() {
                onLoadingVm().showLoadingFun(true)
                binding.progressBar.visibility=View.VISIBLE
                repolistViewModel.getRepoList("Android")
            }
            override fun offline() {
                onSnackBarVm().setMSg("Please Connect Internet Connection")
            }
        })

        getLivedata()

    }



    private fun getLivedata() {
        repolistViewModel.reposityoryITem.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility=View.GONE
            it.getContentIfNotHandled().let {
                Log.e("get data",it.toString())
                binding.recylerRepositoryList.adapter = adapter
                it?.let { it1 -> adapter.sendRepositoryList(it.items,this) }
                adapter.notifyDataSetChanged()
                val companiesString = gson.toJson(it)
                try {

                    val type: Type =
                        object : TypeToken<GithubDetails>() {}.type
                    githubDetails =
                        gson.fromJson<List<GithubDetails>>(companiesString, type)
                    Log.e("gitdetails",githubDetails.toString())
                }catch (e:Exception){

                }

            }
        })


    }

    override fun onClick(itme: Item) {
        val bundle = bundleOf("detailsowner" to itme)
        findNavController().navigate(R.id.detailsFragment, bundle)
    }

}