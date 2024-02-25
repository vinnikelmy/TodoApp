package com.example.todoapp.feature_todo.data.repository

import com.example.todoapp.feature_todo.data.TodoDao
import com.example.todoapp.feature_todo.data.mapper.toTodo
import com.example.todoapp.feature_todo.data.mapper.toTodoEntity
import com.example.todoapp.feature_todo.domain.model.Todo
import com.example.todoapp.feature_todo.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoRepositoryImpl(
    private val dao: TodoDao
): TodoRepository {
    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo.toTodoEntity())
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo.toTodoEntity())
    }

    override suspend fun getTodoById(id: Int): Todo? {
        return dao.getTodoById(id)?.toTodo()
    }

    override fun getTodos(): Flow<List<Todo>> {
        return dao.getTodos().map { it ->
            it.map {
                it.toTodo()
            }
        }
    }
}