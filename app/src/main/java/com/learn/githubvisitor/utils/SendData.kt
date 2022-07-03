package com.learn.githubvisitor.utils

import com.learn.githubvisitor.model.GithubDetails
import com.learn.githubvisitor.model.Item
import com.learn.githubvisitor.model.Owner

interface SendData {
    fun onClick(item: Item)
}