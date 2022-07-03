package com.learn.githubvisitor.utils

import androidx.room.TypeConverter
import com.example.example.GithubDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class ProfileTypeConverter {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<GithubDetails> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<GithubDetails>>() {

        }.type

        return gson.fromJson<List<GithubDetails>>(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<GithubDetails>): String {
        return gson.toJson(someObjects)
    }
}

class OtherServicesTypeConverter {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): ArrayList<HashMap<String, GithubDetails>> {
        if (data == null) {
            return ArrayList()
        }

        val listType = object : TypeToken<ArrayList<HashMap<String, GithubDetails>>>() {

        }.type

        return gson.fromJson<ArrayList<HashMap<String, GithubDetails>>>(data, listType)
    }

    @TypeConverter
    fun listToString(objects: ArrayList<HashMap<String, GithubDetails>>): String {
        return gson.toJson(objects)
    }
}