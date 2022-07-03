package com.learn.githubvisitor.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.githubvisitor.model.GitHubDB
import com.learn.githubvisitor.utils.GithubShowModel
import com.learn.githubvisitor.utils.RequestCompleteListener

class GithubViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val failurProduct = MutableLiveData<String>()
    var listRepo: MutableLiveData<List<GitHubDB>>? = MutableLiveData()
    var githAdd = MutableLiveData<GitHubDB>()

    fun addData(
        title: String,
        descrition: String,
        imageurl: String,
        name: String,
        date: String,
        model: GithubShowModel
    ) {
        isLoading.postValue(true)
        model.githubListShowModel(
            title, descrition, imageurl, name, date,
            object : RequestCompleteListener<GitHubDB> {
                override fun onRequestSuccess(data: GitHubDB) {
                    githAdd.postValue(data)
                    isLoading.postValue(false)
                }

                override fun onRequestFailed(errorMessage: String) {
                    failurProduct.postValue(errorMessage)
                    isLoading.postValue(false)

                }

            })
    }

    fun getallData( model: GithubShowModel) {
        isLoading.postValue(true)
        model.getListGithub(object : RequestCompleteListener<List<GitHubDB>> {
            override fun onRequestSuccess(data: List<GitHubDB>) {
                isLoading.postValue(false)
                listRepo?.postValue(data)

            }

            override fun onRequestFailed(errorMessage: String) {
                failurProduct.postValue(errorMessage)
                isLoading.postValue(false)
            }


        })

    }
}