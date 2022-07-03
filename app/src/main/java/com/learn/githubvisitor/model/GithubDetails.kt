package com.example.example

import androidx.room.Entity
import com.google.gson.annotations.SerializedName


@Entity(tableName = "repository")
data class GithubDetails (

  @SerializedName("total_count"        ) var totalCount        : Int?             = null,
  @SerializedName("incomplete_results" ) var incompleteResults : Boolean?         = null,
  @SerializedName("items"              ) var items             : ArrayList<Item> = arrayListOf()

)