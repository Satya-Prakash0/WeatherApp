//package com.example.myapplication2.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.navArgument
//import com.example.myapplication2.ui.screens.DetailScreen
//import com.example.myapplication2.ui.screens.ListScreen
//import com.example.myapplication2.viewModel.MainViewModel
//
//@Composable
//fun NavGraph(navController: NavHostController, viewModel:MainViewModel) {
//
//    NavHost(navController = navController, startDestination = Screens.ListScreen.route) {
//
//        composable(route = Screens.ListScreen.route) {
//            ListScreen(navController,viewModel)
//        }
//
//        composable(
//            route = Screens.DetailScreen.route,
//            arguments = listOf(navArgument("id"){type = NavType.IntType})
//        ) {
//            val id = it.arguments?.getInt("id") ?: 0
//            DetailScreen(id,viewModel)
//        }
//    }
//}
//
