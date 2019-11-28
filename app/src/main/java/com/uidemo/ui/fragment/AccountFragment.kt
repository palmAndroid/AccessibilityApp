package com.uidemo.ui.fragment

import BaseActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demo.accessibilityapp.tab_module.Tabs
import com.uidemo.R
import com.uidemo.ui.viewmodel.AccountViewModel
import com.uidemo.constants.Constants
import com.uidemo.list_module.RecyclerList


class AccountFragment  : Fragment() {

    private lateinit var accountViewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        accountViewModel = ViewModelProviders.of(this).get(AccountViewModel::class.java)

        (activity as BaseActivity).setHeaderTitle(requireActivity().getString(R.string.title_account))

        val root = inflater.inflate(R.layout.fragment_account, container, false)

        accountViewModel.list.observe(this, Observer {
          RecyclerList(requireActivity(),root).createListWithArray(it)
        })


        Tabs(childFragmentManager).setUpTabs(root,Constants().tab_fragments,
            resources.getStringArray(R.array.tab_items), Constants().tab_icons)

        return root
    }

}