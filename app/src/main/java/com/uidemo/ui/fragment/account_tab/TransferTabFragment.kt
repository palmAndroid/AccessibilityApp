package com.uidemo.ui.fragment.account_tab


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.uidemo.R
import com.uidemo.ui.viewmodel.TransferTabViewModel
import com.uidemo.list_module.RecyclerList as RecyclerList1

class TransferTabFragment : Fragment() {

    private lateinit var transferTabViewModel : TransferTabViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        transferTabViewModel = ViewModelProviders.of(this).get(TransferTabViewModel::class.java)

        val root = inflater.inflate(R.layout.tab_fragment_transfer, container, false)

        transferTabViewModel.list.observe(this, Observer {

            RecyclerList1(requireActivity(), root).createListWithArray(it)
        })

        return root
    }
}