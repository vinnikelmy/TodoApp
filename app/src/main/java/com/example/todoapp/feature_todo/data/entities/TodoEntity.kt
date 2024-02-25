package com.example.todoapp.feature_todo.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoEntity(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val description: String?,
    val completed: Boolean
)