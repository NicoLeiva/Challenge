package com.example.challenge.conecction

import com.example.challenge.model.PhoneListItem
import com.example.challenge.model.PhoneListX
import retrofit2.Response

class ApiClient (
    private val apiService: ApiService) {

    suspend fun getAllPhones(): Response<PhoneListX>? {

        return apiService.getAllPhones()
    }

    suspend fun getDetailsPhone(id:String): Response<PhoneListItem>{
        return apiService.getDetailsPhone(id)
    }
}