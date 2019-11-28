package com.uidemo.list_module

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uidemo.R


class RecyclerList(var activity: Activity, var root : View){

    lateinit var list : RecyclerView

   fun createListWithArray(array : ArrayList<String>){
       list = root.findViewById(R.id.list)
       list.layoutManager = LinearLayoutManager(activity)
       list.adapter = RecyclerListAdapter(array, activity)
   }
}