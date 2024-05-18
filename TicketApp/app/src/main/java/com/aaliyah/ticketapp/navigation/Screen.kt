package com.aaliyah.ticketapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Promo: Screen("promo")
    object Profile : Screen("profile")
    object SearchResult : Screen("search_result")
}
