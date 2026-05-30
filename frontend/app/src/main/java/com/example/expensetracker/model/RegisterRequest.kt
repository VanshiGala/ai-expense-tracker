package com.example.expensetracker.model

data class RegisterRequest(
    val name:String,
    val email:String,
    val password:String
)