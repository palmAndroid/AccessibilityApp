package com.uidemo

import BaseActivity
import android.os.Bundle

import androidx.appcompat.widget.Toolbar
import com.uidemo.constants.Constants

class NavigationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        setActivityType(Constants().NAVIGATION_TYPE)
    }

}
