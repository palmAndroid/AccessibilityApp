package com.uidemo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginPreferenceViewModel  : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Login Preference Fragment"
    }
    val text: LiveData<String> = _text
}