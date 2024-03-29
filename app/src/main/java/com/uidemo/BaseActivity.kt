

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.accessibility.AccessibilityEvent
import androidx.appcompat.app.AppCompatActivity
import com.uidemo.HelpActivity
import com.uidemo.R
import com.uidemo.constants.Constants
import com.uidemo.navigation.Navigator


 open class BaseActivity : AppCompatActivity() {

     private var actType : Int = 0;
     private var navigator = Navigator()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

     fun setHeaderTitle(title : String){
         supportActionBar?.title = title
     }

    fun setActivityType(type : Int) {
        actType = type
        when (type) {
            Constants().NAVIGATION_TYPE -> {
                (navigator).initialSetUp(this)
            }
            else -> {
                print("x is neither 1 nor 2")
            }
        }
    }

     override fun onCreateOptionsMenu(menu: Menu): Boolean {
         when (actType) {
             Constants().NAVIGATION_TYPE ->    this.menuInflater.inflate(R.menu.main, menu)
         }
         return super.onCreateOptionsMenu(menu)
     }

    override fun onSupportNavigateUp(): Boolean {
        when (actType){
            Constants().NAVIGATION_TYPE -> {
               var isNavigate : Boolean =  navigator.onSupportNavigateUp()
                return isNavigate
            }
        }
        return false
    }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         if (actType==Constants().NAVIGATION_TYPE){
             when(item.itemId){
                 R.id.action_settings -> {
                     val intent = Intent(this, HelpActivity::class.java)
                     startActivity(intent)
                 }
             }
         }
         return super.onOptionsItemSelected(item)
     }
}