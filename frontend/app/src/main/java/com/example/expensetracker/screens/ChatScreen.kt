package com.example.expensetracker.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

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

import kotlinx.coroutines.launch

import androidx.compose.runtime.rememberCoroutineScope

import com.example.expensetracker.repository.ExpenseRepo

@Composable
fun ChatScreen() {

    val repo = remember {
        ExpenseRepo()
    }

    var question by remember {
        mutableStateOf("")
    }

    var answer by remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    Column(
        Modifier.padding(20.dp)
    ) {

        OutlinedTextField(
            value = question,
            onValueChange = {
                question = it
            }
        )

        Button(
            onClick = {

                scope.launch {

                    answer =
                        repo.askAI(question)
                            .answer
                }
            }
        ) {
            Text("Ask AI")
        }

        Spacer(Modifier.height(20.dp))

        Text(answer)
    }
}