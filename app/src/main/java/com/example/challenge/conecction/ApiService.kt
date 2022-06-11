package com.example.challenge.conecction

import com.example.challenge.model.PhoneListItem
import com.example.challenge.model.PhoneListX
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("devices/")
    suspend fun getAllPhones(): Response<PhoneListX>

    @GET("devices/{id}/")
    suspend fun getDetailsPhone(@Path( "id") id:String): Response<PhoneListItem>
}