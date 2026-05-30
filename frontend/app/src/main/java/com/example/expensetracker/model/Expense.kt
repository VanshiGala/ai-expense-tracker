package com.example.expensetracker.model

data class Expense(
    val id:Int? = null,
    val title:String,
    val amount:Double,
    val category:String,
    val merchant:String
)