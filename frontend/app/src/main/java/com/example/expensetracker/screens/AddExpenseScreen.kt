package com.example.expensetracker.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height

import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.expensetracker.model.Expense
import com.example.expensetracker.viewmodel.ExpenseViewModel

@Composable
fun AddExpenseScreen(
    vm: ExpenseViewModel
) {

    var title by remember {
        mutableStateOf("")
    }

    var amount by remember {
        mutableStateOf("")
    }

    var category by remember {
        mutableStateOf("")
    }

    var merchant by remember {
        mutableStateOf("")
    }

    Column(
        Modifier.padding(20.dp)
    ) {

        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
            },
            label = {
                Text("Title")
            }
        )

        OutlinedTextField(
            value = amount,
            onValueChange = {
                amount = it
            },
            label = {
                Text("Amount")
            }
        )

        OutlinedTextField(
            value = category,
            onValueChange = {
                category = it
            }
        )

        OutlinedTextField(
            value = merchant,
            onValueChange = {
                merchant = it
            }
        )

        Button(
            onClick = {

                vm.addExpense(
                    Expense(
                        title = title,
                        amount = amount.toDouble(),
                        category = category,
                        merchant = merchant
                    )
                )
            }
        ) {
            Text("Save Expense")
        }
    }
}