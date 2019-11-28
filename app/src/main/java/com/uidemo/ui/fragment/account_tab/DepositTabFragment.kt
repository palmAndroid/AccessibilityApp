package com.uidemo.ui.fragment.account_tab

import BaseActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.uidemo.R
import com.uidemo.ui.viewmodel.DepositTabViewModel

class DepositTabFragment : Fragment() {

    private lateinit var depositTabViewModel: DepositTabViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        depositTabViewModel = ViewModelProviders.of(this).get(DepositTabViewModel::class.java)

        val root = inflater.inflate(R.layout.tab_fragment_deposit, container, false)

       (activity as BaseActivity).setHeaderTitle(requireActivity().getString(R.string.title_deposit))

        depositTabViewModel.text.observe(this, Observer {})
        return root
    }
}