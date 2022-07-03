package com.walton.eapp.network

import com.example.example.GithubDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface GitHubApiInterface {
   @GET("search/repositories")
   fun getRepositoryList(
      @Query("q") query:String,
   ): Call<GithubDetails>
   }