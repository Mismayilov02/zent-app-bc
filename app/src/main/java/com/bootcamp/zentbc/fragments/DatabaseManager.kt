package com.bootcamp.zentbc.fragments

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoModel::class], version = 1)
abstract class DatabaseManager: RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object{
        const val DATABASE_NAME = "todo.db"

        private var INSTANCE: DatabaseManager? = null

        fun getINSTANCE(context: Context): DatabaseManager{
            return INSTANCE ?: synchronized(this){
                INSTANCE = Room.databaseBuilder(context, DatabaseManager::class.java,DATABASE_NAME).build()
                INSTANCE!!
            }
        }
    }
}