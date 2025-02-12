package com.bootcamp.zentbc.fragments

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {
    @Insert
    suspend fun insert(todo: TodoModel)

    @Query("SELECT * FROM todo")
    suspend fun getAllTodo(): List<TodoModel>

    @Update
    suspend fun update(todo: TodoModel)

    @Query("UPDATE todo SET status = :status WHERE id=:id")
    suspend fun updateStatusById(id: Int,status: TodoStatus)

    @Delete
    suspend fun delete(todo: TodoModel)
}