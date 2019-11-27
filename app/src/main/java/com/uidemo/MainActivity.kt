package com.uidemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.uidemo.alert.AlertDialogView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null)
            supportActionBar?.hide()

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        var btnLoginHelp = findViewById<TextView>(R.id.text_login_help)

        btnLoginHelp.setOnClickListener {
            AlertDialogView(this).showCustomDialog()
        }

        var btnLogin = findViewById<Button>(R.id.buttonLogin)

        btnLogin.setOnClickListener{
            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }
    }


}
