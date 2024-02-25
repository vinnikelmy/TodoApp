package com.example.todoapp.feature_todo.data.mapper

import com.example.todoapp.feature_todo.data.entities.TodoEntity
import com.example.todoapp.feature_todo.domain.model.Todo

fun TodoEntity.toTodo(): Todo {
    return Todo(
        id = id,
        title = title,
        description = description,
        completed = completed
    )
}

fun Todo.toTodoEntity(): TodoEntity {
    return TodoEntity(
        id = id,
        title = title,
        description = description,
        completed = completed
    )
}