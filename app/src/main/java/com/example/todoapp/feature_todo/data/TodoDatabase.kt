package com.example.todoapp.feature_todo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.feature_todo.data.entities.TodoEntity

@Database(
    entities = [
        TodoEntity::class
    ],
    version = 1
)
abstract class TodoDatabase: RoomDatabase() {
    abstract val dao: TodoDao
}