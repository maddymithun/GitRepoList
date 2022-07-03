package com.learn.githubvisitor.repository

import com.learn.githubvisitor.callback.RepositoryCallBack
import com.learn.githubvisitor.model.GithubDetails
import com.learn.githubvisitor.model.Item
import com.walton.eapp.network.GitHubApiInterface
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class GithubRepositoryListRepository @Inject constructor(private val api: GitHubApiInterface) {
    fun getRepoSerachList(
        query: String,
        onCallBack: RepositoryCallBack
    ) {

        api.getRepositoryList(query)
            .enqueue(object : retrofit2.Callback<GithubDetails> {
                override fun onResponse(
                    call: Call<GithubDetails>, response: Response<GithubDetails>
                ) {
                    onCallBack.onSubmitSueccess(response.body()!!)
                }

                override fun onFailure(call: Call<GithubDetails>, t: Throwable) {
                    onCallBack.onError(
                        "Please try it again"
                    )
                }

            })
    }
}