package com.hoole.feature.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(state: DashboardState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DashboardStatCard(title = "Total tâches", value = state.totalTasks.toString())
        Spacer(Modifier.height(12.dp))
        DashboardStatCard(title = "Tâches terminées", value = state.completedTasks.toString())
        Spacer(Modifier.height(12.dp))
        DashboardStatCard(title = "Tâches urgentes", value = state.urgentTasks.toString())

        Spacer(Modifier.height(20.dp))
        Text("Résumé du jour", style = MaterialTheme.typography.titleMedium)
        Text("• ${state.completedToday} tâche(s) terminée(s) aujourd'hui")
        Text("• ${state.urgentTasks} tâche(s) urgente(s) en attente")
    }
}

@Composable
private fun DashboardStatCard(title: String, value: String) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(title, style = MaterialTheme.typography.bodyMedium)
            Text(value, style = MaterialTheme.typography.headlineSmall)
        }
    }
}

data class DashboardState(
    val totalTasks: Int = 0,
    val completedTasks: Int = 0,
    val urgentTasks: Int = 0,
    val completedToday: Int = 0
)
