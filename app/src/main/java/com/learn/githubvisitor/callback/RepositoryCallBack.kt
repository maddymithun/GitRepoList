package com.learn.githubvisitor.callback

import com.learn.githubvisitor.model.GithubDetails
import com.learn.githubvisitor.model.Item


interface RepositoryCallBack {
    fun onSubmitSueccess(data: GithubDetails)
    fun onError(message: String)
}