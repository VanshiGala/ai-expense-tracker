package com.example.expensetracker.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

import com.example.expensetracker.model.ChatRequest
import com.example.expensetracker.model.ChatResponse
import com.example.expensetracker.model.Expense
import com.example.expensetracker.model.RegisterRequest
import com.example.expensetracker.model.SummaryResponse
interface ApiService {

    @POST("auth/register")
    suspend fun register(
        @Body request:RegisterRequest
    )

    @POST("expenses/")
    suspend fun addExpense(
        @Body expense:Expense
    ): Expense

    @GET("expenses/")
    suspend fun getExpenses(): List<Expense>

    @GET("insights/summary")
    suspend fun getSummary(): SummaryResponse

    @POST("chat/")
    suspend fun askAI(
        @Body request: ChatRequest //send obj as JSON req body
    ): ChatResponse
}