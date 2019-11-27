package com.uidemo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ManageCardsViewModel  : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Manage Cards Fragment"
    }
    val text: LiveData<String> = _text
}