package com.example.challenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge.model.PhoneListItem
import com.example.challenge.model.PhoneListX
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhoneViewModel : ViewModel() {

    private val repository = PhoneRepository()

    private val _allPhonesLiveData = MutableLiveData<PhoneListX>()

    private val _detailsPhoneLiveData = MutableLiveData<PhoneListItem>()

    fun getAllPhones():MutableLiveData<PhoneListX>{
    viewModelScope.launch {
        val response = repository.getAllPhones()
        _allPhonesLiveData.postValue(response)
        }
        return _allPhonesLiveData
    }

    fun getPhoneDetails(id:String):MutableLiveData<PhoneListItem>{
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPhoneDetails(id)
            _detailsPhoneLiveData.postValue(response)
        }
        return _detailsPhoneLiveData
    }
}