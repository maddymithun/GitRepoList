package com.learn.githubvisitor.utils

import androidx.room.TypeConverter
import com.example.example.GithubDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

object ItemTypeConvert {
    private val gson = Gson()
    @TypeConverter
    @JvmStatic
    fun stringToList(data: String?): List<Map<String, GithubDetails>> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<Map<String, GithubDetails>>>() {

        }.type

        return gson.fromJson<List<Map<String, GithubDetails>>>(data, listType)
    }

    @TypeConverter
    @JvmStatic
    fun listToString(objects: List<Map<String, GithubDetails>>): String {
        return gson.toJson(objects)
    }
}