package com.learn.githubvisitor.utils

import com.learn.githubvisitor.model.GitHubDB

interface GithubShowModel {
    fun githubListShowModel(
        title: String,
        descritpion: String,
        image: String,
        name: String,
        date: String,
        callback: RequestCompleteListener<GitHubDB>
    )

    fun getListGithub(callback: RequestCompleteListener<List<GitHubDB>>)

}