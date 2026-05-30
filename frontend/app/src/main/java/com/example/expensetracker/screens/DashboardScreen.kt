package com.example.expensetracker.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController

import com.example.expensetracker.viewmodel.ExpenseViewModel

@Composable
fun DashboardScreen(
    navController: NavController,
    vm: ExpenseViewModel
) {

    LaunchedEffect(Unit) {
        vm.loadExpenses()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            "AI Expense Tracker",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(20.dp))

        Card {

            Column(
                Modifier.padding(20.dp)
            ) {

                Text("Total Expenses")

                Text(
                    "₹ ${vm.totalExpense}",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("add")
            }
        ) {
            Text("Add Expense")
        }

        Button(
            onClick = {
                navController.navigate("list")
            }
        ) {
            Text("View Expenses")
        }

        Button(
            onClick = {
                navController.navigate("chat")
            }
        ) {
            Text("AI Assistant")
        }
    }
}