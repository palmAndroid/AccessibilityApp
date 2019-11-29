package com.uidemo.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.uidemo.R

class Navigator{

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var activity : AppCompatActivity
    private lateinit var drawerLayout :  DrawerLayout

     fun initialSetUp(activity: AppCompatActivity): AppBarConfiguration {
         this.activity = activity
          drawerLayout = activity.findViewById(R.id.drawer_layout)
         val navView: NavigationView = activity.findViewById(R.id.nav_view)
         val navController = activity.findNavController(R.id.nav_host_fragment)

         appBarConfiguration = AppBarConfiguration(
             setOf(
                 R.id.nav_accounts, R.id.nav_transfer, R.id.nav_explore,
                 R.id.nav_login, R.id.nav_notifications, R.id.nav_manage,
                 R.id.nav_statement, R.id.nav_help
             ), drawerLayout
         )
         activity.setupActionBarWithNavController(navController, appBarConfiguration)
         navView.setupWithNavController(navController)
         return appBarConfiguration
    }

     fun onSupportNavigateUp(): Boolean {
        val navController = activity.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || onSupportNavigateUp()
    }
}

