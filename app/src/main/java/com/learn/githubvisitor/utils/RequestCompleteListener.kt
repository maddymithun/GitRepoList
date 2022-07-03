package com.learn.githubvisitor.utils

interface RequestCompleteListener <T> {
    fun onRequestSuccess(data: T)
    fun onRequestFailed(errorMessage: String)
}