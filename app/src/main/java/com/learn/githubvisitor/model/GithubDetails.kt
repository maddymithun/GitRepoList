package com.learn.githubvisitor.model

data class GithubDetails(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)