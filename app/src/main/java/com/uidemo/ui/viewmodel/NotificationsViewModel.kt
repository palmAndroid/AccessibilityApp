package com.uidemo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel  : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Notification Fragment"
    }
    val text: LiveData<String> = _text
}