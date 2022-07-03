package com.walton.eapp.network

import com.learn.githubvisitor.model.GithubDetails
import com.learn.githubvisitor.model.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.Url


interface GitHubApiInterface {
   @GET("search/repositories")
   fun getRepositoryList(
      @Query("q") query:String,
   ): Call<GithubDetails>
   }