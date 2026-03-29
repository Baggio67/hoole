package com.hoole

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.hoole.core.ui.theme.HooleTheme
import com.hoole.feature.dashboard.DashboardScreen
import com.hoole.feature.dashboard.DashboardState
import com.hoole.feature.notes.NoteListItem
import com.hoole.feature.notes.NotesScreen
import com.hoole.feature.tasks.TaskListItem
import com.hoole.feature.tasks.TasksScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HooleTheme {
                MainContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainContent() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Notes", "Tâches", "Dashboard")

    Scaffold(
        topBar = { androidx.compose.material3.TopAppBar(title = { Text("Hoole") }) }
    ) { padding ->
        androidx.compose.foundation.layout.Column(
            modifier = androidx.compose.ui.Modifier.padding(padding)
        ) {
            TabRow(selectedTabIndex = selectedTab) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(title) }
                    )
                }
            }

            when (selectedTab) {
                0 -> NotesScreen(
                    notes = listOf(
                        NoteListItem(1, "Bienvenue", "Crée ta première note"),
                        NoteListItem(2, "Idées", "Ajouter tags et catégories")
                    )
                )

                1 -> TasksScreen(
                    tasks = listOf(
                        TaskListItem(1, "Brancher Room", false, "HIGH", "Aujourd'hui 18:00"),
                        TaskListItem(2, "Écrire tests", true, "MEDIUM")
                    ),
                    onToggleDone = {}
                )

                else -> DashboardScreen(
                    state = DashboardState(
                        totalTasks = 8,
                        completedTasks = 3,
                        urgentTasks = 2,
                        completedToday = 1
                    )
                )
            }
        }
    }
}
