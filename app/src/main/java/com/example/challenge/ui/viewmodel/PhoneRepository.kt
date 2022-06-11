package com.example.challenge.ui.viewmodel

import com.example.challenge.conecction.RetrofitConnection
import com.example.challenge.model.PhoneListItem
import com.example.challenge.model.PhoneListX

class PhoneRepository {

    suspend fun getAllPhones() : PhoneListX? {
        val request = RetrofitConnection.apiClient.getAllPhones()
        if (request != null) {
            if( request.isSuccessful)
                return request.body()
        }
        return null
    }

    suspend fun getPhoneDetails(id:String) : PhoneListItem? {
        val request = RetrofitConnection.apiClient.getDetailsPhone(id)
        if( request.isSuccessful)
            return request.body()!!
        return null
    }

}
