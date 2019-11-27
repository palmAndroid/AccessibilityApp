package com.uidemo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExploreProductsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is ExploreProducts Fragment"
    }
    val text: LiveData<String> = _text
}