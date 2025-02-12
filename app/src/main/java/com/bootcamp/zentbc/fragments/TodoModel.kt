package com.bootcamp.zentbc.fragments

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.coroutines.internal.OpDescriptor
import java.util.Date

@Entity(tableName = "todo")
data class TodoModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val deadline: Long = Date().time + 24*60*60*1000,
    var status : TodoStatus = TodoStatus.TODO,
    val author: String
)
