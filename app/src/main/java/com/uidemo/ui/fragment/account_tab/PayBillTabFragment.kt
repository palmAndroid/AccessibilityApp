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
import com.uidemo.ui.viewmodel.PayBillTabViewModel

class PayBillTabFragment : Fragment() {

    private lateinit var payBillTabViewModel: PayBillTabViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        payBillTabViewModel = ViewModelProviders.of(this).get(PayBillTabViewModel::class.java)
        val root = inflater.inflate(R.layout.tab_fragment_paybill, container, false)

    //    (activity as BaseActivity).setHeaderTitle(requireActivity().getString(R.string.title_paybill))

        payBillTabViewModel.text.observe(this, Observer {
            //Toast.makeText(activity,it, Toast.LENGTH_LONG).show()
        })
        return root
    }
}