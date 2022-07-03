package com.learn.githubvisitor.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.githubvisitor.callback.RepositoryCallBack
import com.learn.githubvisitor.model.GithubDetails
import com.learn.githubvisitor.model.Item
import com.learn.githubvisitor.repository.GithubRepositoryListRepository
import com.walton.eapp.utils.ApiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RepositoryViewModel  @Inject constructor(private  val repoList: GithubRepositoryListRepository):
    ViewModel(),RepositoryCallBack {
    val reposityoryITem = MutableLiveData<ApiEvent<GithubDetails>>()
    val errorResponse = MutableLiveData<ApiEvent<String>>()
    fun getRepoList(query:String) {
        repoList.getRepoSerachList(query, this)
    }

    override fun onSubmitSueccess(data: GithubDetails) {
        reposityoryITem.value= ApiEvent(data)
    }

    override fun onError(message: String) {

    }
}