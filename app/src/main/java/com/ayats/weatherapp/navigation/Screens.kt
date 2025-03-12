package com.example.myapplication2.navigation

sealed class Screens(val route: String) {
    data object ListScreen : Screens("list_screen")
    data object DetailScreen : Screens("detail_screen/{id}")
}