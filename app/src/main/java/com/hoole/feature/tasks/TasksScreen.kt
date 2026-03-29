package com.hoole.feature.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TasksScreen(
    tasks: List<TaskListItem>,
    onToggleDone: (Long) -> Unit
) {
    LazyColumn {
        items(tasks) { task ->
            Card(modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = task.isDone,
                        onCheckedChange = { onToggleDone(task.id) }
                    )
                    Column {
                        Text(task.title, style = MaterialTheme.typography.titleMedium)
                        task.deadlineLabel?.let { Text(it, style = MaterialTheme.typography.bodySmall) }
                        Text("Priorité: ${task.priorityLabel}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

data class TaskListItem(
    val id: Long,
    val title: String,
    val isDone: Boolean,
    val priorityLabel: String,
    val deadlineLabel: String? = null
)
