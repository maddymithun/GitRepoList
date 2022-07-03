package com.learn.githubvisitor.callback

import com.example.example.GithubDetails


interface RepositoryCallBack {
    fun onSubmitSueccess(data: GithubDetails)
    fun onError(message: String)
}