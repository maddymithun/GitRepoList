package com.learn.githubvisitor.utils

import com.example.example.Item
import com.learn.githubvisitor.model.GitHubDB

interface OffSendData {
    fun onClickOffLine(item: GitHubDB)
}