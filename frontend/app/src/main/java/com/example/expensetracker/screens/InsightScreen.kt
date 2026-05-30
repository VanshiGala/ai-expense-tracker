package com.example.expensetracker.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Card
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.expensetracker.viewmodel.ExpenseViewModel

@Composable
fun InsightsScreen(
    vm: ExpenseViewModel
) {

    LaunchedEffect(Unit) {
        vm.loadExpenses()
    }

    Card(
        modifier = Modifier.padding(20.dp)
    ) {

        Column(
            Modifier.padding(20.dp)
        ) {

            Text(
                "Total Spending"
            )

            Text(
                "₹ ${vm.totalExpense}"
            )
        }
    }
}