package com.example.expensetracker.navigation

//navigation hub -> defines all screens and how users move between them

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.expensetracker.screens.AddExpenseScreen
import com.example.expensetracker.screens.ChatScreen
import com.example.expensetracker.screens.DashboardScreen
import com.example.expensetracker.screens.ExpenseListScreen
import com.example.expensetracker.screens.InsightsScreen
import com.example.expensetracker.viewmodel.ExpenseViewModel
@Composable //() contains all navigation routes
fun NavGraph() {

    val navController =
        rememberNavController()

    //single view model instance -> all screen share the same state/data
    val vm: ExpenseViewModel =
        viewModel()

    NavHost(
        navController,
        startDestination = "dashboard"
    ) {

        composable("dashboard") {
            DashboardScreen(
                navController,
                vm
            )
        }

        composable("add") {
            AddExpenseScreen(vm)
        }

        composable("list") {
            ExpenseListScreen(vm)
        }

        composable("chat") {
            ChatScreen()
        }

        composable("insights") {
            InsightsScreen(vm)
        }
    }
}