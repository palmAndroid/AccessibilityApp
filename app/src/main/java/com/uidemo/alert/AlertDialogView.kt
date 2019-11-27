package com.uidemo.alert

import android.app.Activity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.uidemo.R

class AlertDialogView {

     var activity : Activity

    constructor(activity: Activity) {
        this.activity = activity
    }

    fun showCustomDialog() {
        val dialogBuilder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        val dialogView = inflater.inflate(R.layout.login_help_dialog, null)
        dialogBuilder.setCancelable(true)
        dialogBuilder.setView(dialogView)
        val b = dialogBuilder.create()

        var btnForgetPassword = dialogView.findViewById(R.id.btnForgetPassword) as Button
        var btnResetPassword = dialogView.findViewById(R.id.btnResetPassword) as Button
        var btnCancel = dialogView.findViewById(R.id.btnCancel) as Button

        btnForgetPassword.setOnClickListener {
            Toast.makeText(activity,activity.getString(R.string.forgot_username), Toast.LENGTH_SHORT).show()
        }
        btnResetPassword.setOnClickListener {
            Toast.makeText(activity,activity.getString(R.string.reset_password), Toast.LENGTH_SHORT).show()
        }
        btnCancel.setOnClickListener {
            Toast.makeText(activity,activity.getString(R.string.cancel), Toast.LENGTH_SHORT).show()
            b.dismiss()
        }

        b.show()
    }
}