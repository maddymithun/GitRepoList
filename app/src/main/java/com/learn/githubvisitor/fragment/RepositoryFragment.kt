package com.learn.githubvisitor.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.example.GithubDetails
import com.example.example.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learn.githubvisitor.R
import com.learn.githubvisitor.adapter.OffLineAdapter
import com.learn.githubvisitor.adapter.RepositoryAdapter
import com.learn.githubvisitor.config.CheckNetworkStatus
import com.learn.githubvisitor.databinding.FragmentRepositoryBinding
import com.learn.githubvisitor.db.RepoDatabase
import com.learn.githubvisitor.model.GitHubDB
import com.learn.githubvisitor.repository.GitHubDBRepository
import com.learn.githubvisitor.utils.OffSendData
import com.learn.githubvisitor.utils.SendData
import com.learn.githubvisitor.viewModel.GithubViewModel
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
    BaseFragmentWithBinding<FragmentRepositoryBinding>(FragmentRepositoryBinding::inflate),
    SendData,OffSendData {
    val repolistViewModel: RepositoryViewModel by viewModels()
    var githubRepository: GitHubDBRepository? = null
    lateinit var githubViewmodel: GithubViewModel
    private lateinit var myDb: RepoDatabase

    @Inject
    lateinit var adapter: RepositoryAdapter
    @Inject
    lateinit var offLineAdapter: OffLineAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoadingVm().updateToolbar("Repository List")
        initlize()
        CheckNetworkStatus.isOnline(requireContext(), object : CheckNetworkStatus.Status {
            override fun online() {
                onLoadingVm().showLoadingFun(true)
                binding.progressBar.visibility = View.VISIBLE
                repolistViewModel.getRepoList("Android")
            }

            override fun offline() {
                binding.progressBar.visibility = View.VISIBLE
                onSnackBarVm().setMSg("Please Connect Internet Connection")
                githubViewmodel.getallData(githubRepository!!)

            }
        })

        getLivedata()

    }

    private fun initlize() {
        githubRepository = context?.let { GitHubDBRepository(it) }
        githubViewmodel = ViewModelProviders.of(this).get(GithubViewModel::class.java)
        myDb = RepoDatabase.getDataseClient(context!!)


    }


    private fun getLivedata() {

        repolistViewModel.reposityoryITem.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            it.getContentIfNotHandled().let {
                Log.e("get data", it.toString())
                binding.recylerRepositoryList.adapter = adapter
                it?.let { it1 -> adapter.sendRepositoryList(it.items, this) }
                adapter.notifyDataSetChanged()
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        myDb = RepoDatabase.getDataseClient(context!!)
                        myDb.daoAccess().nullTable()
                        for (i in it?.items!!.indices) {
                            githubViewmodel.addData(
                                it.items[i].fullName!!,
                                it.items[i].description.toString(),
                                it.items[i].owner!!.avatarUrl!!,
                                it.items[i].owner!!.login!!,
                                it.items[i].updatedAt!!,
                                githubRepository!!
                            )

                        }
                    } catch (e: Exception) {

                    }

                }


            }
        })
        githubViewmodel.listRepo?.observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            if (it.size>0){
                binding.recylerRepositoryList.adapter = offLineAdapter
                offLineAdapter.sendOffline(it,this@RepositoryFragment)
                offLineAdapter.notifyDataSetChanged()
                Log.e("data check",it.toString())
            }
        })

    }

    override fun onClick(itme: Item) {


        val bundle = bundleOf("detailsowner" to itme)
        findNavController().navigate(R.id.detailsFragment, bundle)
    }

    override fun onClickOffLine(items: GitHubDB) {
        val bundle = bundleOf("offline" to items)
        findNavController().navigate(R.id.detailsFragment, bundle)
    }

}