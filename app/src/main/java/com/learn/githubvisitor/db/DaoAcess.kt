package com.learn.githubvisitor.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.learn.githubvisitor.model.GitHubDB

@Dao
interface DaoAcess {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertData(repoModel: GitHubDB)
    @Query("SELECT * FROM github")
    fun getRepolist(): List<GitHubDB>

    @Query("DELETE FROM github")
    fun nullTable()
}
