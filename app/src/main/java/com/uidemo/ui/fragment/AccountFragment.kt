package com.uidemo.ui.fragment

import BaseActivity
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demo.accessibilityapp.tab_module.Tabs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.uidemo.R
import com.uidemo.ui.viewmodel.AccountViewModel
import com.uidemo.constants.Constants
import com.uidemo.list_module.RecyclerList


class AccountFragment  : Fragment() {

    private lateinit var accountViewModel: AccountViewModel
    private lateinit var bottomSheetBehavior : BottomSheetBehavior<View>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        accountViewModel = ViewModelProviders.of(this).get(AccountViewModel::class.java)

        (activity as BaseActivity).setHeaderTitle(requireActivity().getString(R.string.title_account))

        val root = inflater.inflate(R.layout.fragment_account, container, false)
        var topLL=root.findViewById<LinearLayout>(R.id.topLL)
        var text_title_bottom_sheet=root.findViewById<TextView>(R.id.text_title_bottom_sheet)

         bottomSheetBehavior = BottomSheetBehavior.from(topLL)

        if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // React to state change
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            text_title_bottom_sheet.announceForAccessibility("Bottom Sheet Opened !slide down with two fingers to close!")
                            text_title_bottom_sheet.isFocusable = true
                            text_title_bottom_sheet.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES

                        }

                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            text_title_bottom_sheet.announceForAccessibility("Bottom Sheet Closed !slide up with two fingers to open!")
                            text_title_bottom_sheet.isFocusable = true
                            text_title_bottom_sheet.importantForAccessibility =
                                View.IMPORTANT_FOR_ACCESSIBILITY_YES
                        }
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                }            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // React to dragging events
            }
        })


        accountViewModel.list.observe(this, Observer {
          RecyclerList(requireActivity(),root).createListWithArray(it)
        })


        Tabs(childFragmentManager, bottomSheetBehavior).setUpTabs(root,Constants().tab_fragments,
            resources.getStringArray(R.array.tab_items), Constants().tab_icons)
        return root
    }

}