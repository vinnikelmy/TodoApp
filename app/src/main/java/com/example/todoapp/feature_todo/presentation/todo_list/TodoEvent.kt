package com.example.todoapp.feature_todo.presentation.todo_list

import com.example.todoapp.feature_todo.domain.model.Todo

sealed class TodoEvent {
    data class OnDeleteTodoClick(val todo: Todo): TodoEvent()
    data class OnDoneChange(val todo: Todo, val completed: Boolean): TodoEvent()
    object OnUndoDeleteClick: TodoEvent()
    data class OnTodoClick(val todo: Todo): TodoEvent()
    object OnAddTodoClick: TodoEvent()
}