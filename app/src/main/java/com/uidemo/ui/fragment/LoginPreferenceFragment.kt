package com.uidemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.uidemo.R
import com.uidemo.ui.viewmodel.AccountViewModel
import com.uidemo.ui.viewmodel.LoginPreferenceViewModel

class LoginPreferenceFragment : Fragment() {

    private lateinit var loginPreferenceViewModel: LoginPreferenceViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginPreferenceViewModel =
            ViewModelProviders.of(this).get(LoginPreferenceViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_login_prfs, container, false)
        loginPreferenceViewModel.text.observe(this, Observer {
            Toast.makeText(activity,it, Toast.LENGTH_LONG).show()
        })
        return root
    }
}