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
import com.uidemo.ui.viewmodel.ExploreProductsViewModel

class ExploreProductsFragment : Fragment() {

    private lateinit var exploreProductsViewModel: ExploreProductsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        exploreProductsViewModel =
            ViewModelProviders.of(this).get(ExploreProductsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_explore, container, false)

        exploreProductsViewModel.text.observe(this, Observer {
            Toast.makeText(activity,it, Toast.LENGTH_LONG).show()
        })
        return root
    }
}