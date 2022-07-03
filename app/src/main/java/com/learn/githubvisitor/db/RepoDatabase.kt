package com.learn.githubvisitor.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.example.Item
import com.example.example.Owner
import com.learn.githubvisitor.model.GitHubDB

@Database(entities = [GitHubDB::class], version = 1)
abstract class RepoDatabase : RoomDatabase() {
    abstract fun daoAccess(): DaoAcess

    companion object {
        private var INSTANCE: RepoDatabase? = null

        fun getDataseClient(context: Context): RepoDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, RepoDatabase::class.java, "repo")
                    .fallbackToDestructiveMigration() .allowMainThreadQueries().build()
                return INSTANCE!!

            }
        }

    }
}