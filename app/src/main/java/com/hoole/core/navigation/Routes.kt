package com.hoole.core.navigation

sealed class Routes(val route: String) {
    data object Notes : Routes("notes")
    data object Tasks : Routes("tasks")
    data object Dashboard : Routes("dashboard")
}
