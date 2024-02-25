package com.example.todoapp.feature_todo.presentation.todo_list.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.feature_todo.domain.model.Todo
import com.example.todoapp.feature_todo.presentation.todo_list.TodoEvent

@Composable
fun TodoItemComponent(
    todo: Todo,
    onEvent: (TodoEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .border(
                border = ButtonDefaults.outlinedButtonBorder,
                shape = RoundedCornerShape(6.dp),
            )
            .padding(15.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        Checkbox(
            checked = todo.completed,
            onCheckedChange = { isChecked ->
                onEvent(TodoEvent.OnDoneChange(todo, isChecked))
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Black,
                uncheckedColor = Color.White,
                checkmarkColor = Color.White
            )
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = todo.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White

                )
                Spacer(modifier = Modifier.width(8.dp))

            }

            todo.description?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it, color = Color.White)
            }
        }
        IconButton(onClick = {
                    onEvent(TodoEvent.OnDeleteTodoClick(todo))
        }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = Color.White
            )
        }
    }
}