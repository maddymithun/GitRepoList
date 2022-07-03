package com.learn.githubvisitor.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.learn.githubvisitor.db.RepoDatabase
import com.learn.githubvisitor.model.GitHubDB
import com.learn.githubvisitor.utils.GithubShowModel
import com.learn.githubvisitor.utils.RequestCompleteListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubDBRepository(private val context: Context) : GithubShowModel {
    var repoDb: RepoDatabase? = null
    var getAllGitData: List<GitHubDB>? = null
    override fun githubListShowModel(
        title: String,
        descritpion: String,
        image: String,
        name: String,
        date: String,
        callback: RequestCompleteListener<GitHubDB>
    ) {
        repoDb = initialize(context)
        CoroutineScope(Dispatchers.IO).launch {
            repoDb!!.daoAccess().InsertData(
                GitHubDB(
                    title,
                    descritpion, image, name, date
                )
            )

        }
    }

    override fun getListGithub(callback: RequestCompleteListener<List<GitHubDB>>) {
        repoDb = initialize(context)
        CoroutineScope(Dispatchers.IO).launch {
            getAllGitData = repoDb!!.daoAccess().getRepolist()
            callback.onRequestSuccess(getAllGitData!!)

        }
    }

    fun initialize(context: Context): RepoDatabase {
        return RepoDatabase.getDataseClient(context)
    }
}