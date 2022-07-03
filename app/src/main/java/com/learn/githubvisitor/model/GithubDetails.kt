package com.example.example

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import com.learn.githubvisitor.utils.ItemTypeConvert


data class GithubDetails (
  @SerializedName("total_count"        ) var totalCount        : Int?             = null,
  @SerializedName("incomplete_results" ) var incompleteResults : Boolean?         = null,
  @ColumnInfo(name = "items") var items : ArrayList<Item> = arrayListOf()

)

