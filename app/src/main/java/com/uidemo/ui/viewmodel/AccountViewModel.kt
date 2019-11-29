package com.uidemo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Account Fragment"
    }
    val text: LiveData<String> = _text

    private val list_items: MutableLiveData<ArrayList<String>> = MutableLiveData<ArrayList<String>>().apply {

        var list : ArrayList<String> = ArrayList()
        list.add("Bottom Activity ")
        list.add("Bottom Reminder")
        list.add("Bottom Notifications")
        list.add("Bottom Shop ")
        list.add("Bottom Sale")
        list.add("Bottom Deposit")

        value = list
    }

    val list : LiveData<ArrayList<String>> = list_items
}