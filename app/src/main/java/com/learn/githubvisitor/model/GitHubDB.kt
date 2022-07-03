package com.learn.githubvisitor.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull
@Entity(tableName = "github")
@Parcelize
data class GitHubDB(
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "descritption")
    val descritption: String,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "date")
    val date: String,

    ) :Parcelable{

    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    var id: Int = 0

}
