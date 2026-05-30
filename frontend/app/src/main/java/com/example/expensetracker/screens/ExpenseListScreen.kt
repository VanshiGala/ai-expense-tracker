package com.example.expensetracker.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Card
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.expensetracker.viewmodel.ExpenseViewModel

@Composable
fun ExpenseListScreen(
    vm: ExpenseViewModel
) {

    LaunchedEffect(Unit) {
        vm.loadExpenses()
    }

    LazyColumn {

        items(vm.expenses) { expense ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Column(
                    Modifier.padding(16.dp)
                ) {

                    Text(expense.title)

                    Text("₹ ${expense.amount}")

                    Text(expense.category)

                    Text(expense.merchant)
                }
            }
        }
    }
}