package com.example.todoapp.feature_todo.domain.model

data class Todo(
    val id: Int? = null,
    val title: String,
    val description: String?,
    val completed: Boolean
)