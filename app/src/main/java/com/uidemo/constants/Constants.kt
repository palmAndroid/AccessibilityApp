package com.uidemo.constants

import com.uidemo.R
import com.uidemo.ui.fragment.account_tab.*


class Constants {

    val NAVIGATION_TYPE : Int = 1
    val BOTTOM_SHEET_TYPE : Int = 2
    val TAB_HOST : Int = 3


    var tab_icons = arrayOf(R.drawable.ic_transfer,R.drawable.ic_deposit,R.drawable.ic_paybill,
        R.drawable.ic_send,R.drawable.ic_shop)

    val tab_fragments = arrayOf(TransferTabFragment(), DepositTabFragment(),
                        PayBillTabFragment(),SendTabFragment(), ShopTabFragment())

}