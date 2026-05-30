package com.example.expensetracker.viewmodel

//allow compose to observe data changes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//survive screen recompositions. store UI and separate it from business logic
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

import com.example.expensetracker.model.Expense
import com.example.expensetracker.repository.ExpenseRepo
class ExpenseViewModel : ViewModel() {

    private val repo = ExpenseRepo()

    var expenses by mutableStateOf<List<Expense>>(emptyList())
        private set

    var totalExpense by mutableStateOf(0.0) //set value and redraw ui

    fun loadExpenses() {

        viewModelScope.launch {

            expenses = repo.getExpenses()

            totalExpense =
                repo.getSummary()
                    .total_expense
        }
    }

    fun addExpense(expense: Expense) {

        viewModelScope.launch {

            repo.addExpense(expense)

            loadExpenses()
        }
    }
}