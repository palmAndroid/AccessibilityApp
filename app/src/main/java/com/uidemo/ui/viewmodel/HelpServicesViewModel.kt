package com.uidemo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HelpServicesViewModel  : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is HelpServicces Fragment"
    }
    val text: LiveData<String> = _text
}