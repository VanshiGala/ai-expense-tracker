package com.example.expensetracker.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL =
        "http://192.168.131.52:8000/" //FastAPI server

    val api: ApiService by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory( //auto conversion
                GsonConverterFactory.create()
            )
            .build()
            .create(ApiService::class.java)
    }
}