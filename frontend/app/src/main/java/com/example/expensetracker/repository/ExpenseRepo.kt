package com.example.expensetracker.repository

import com.example.expensetracker.api.RetrofitClient
import com.example.expensetracker.model.ChatRequest
import com.example.expensetracker.model.Expense
class ExpenseRepo { //class contains all backend operations

    suspend fun getExpenses() =
        RetrofitClient.api.getExpenses()

    suspend fun addExpense(expense: Expense) =
        RetrofitClient.api.addExpense(expense)

    suspend fun getSummary() =
        RetrofitClient.api.getSummary()

    suspend fun askAI(question:String) =
        RetrofitClient.api.askAI(
            ChatRequest(question)
        )
}