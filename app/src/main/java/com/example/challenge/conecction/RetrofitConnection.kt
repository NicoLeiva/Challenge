package com.example.challenge.conecction

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConnection {

    val provideBaseUrl = "https://61967289af46280017e7e0c0.mockapi.io/"

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(provideBaseUrl)
            .build()
    }

    private val apiService:ApiService by lazy {
        provideRetrofit().create(ApiService::class.java)
    }

    val apiClient = ApiClient(apiService)
}