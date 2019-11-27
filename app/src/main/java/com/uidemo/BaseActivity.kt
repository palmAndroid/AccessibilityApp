

import android.os.Bundle
import android.view.Menu

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import com.uidemo.R
import com.uidemo.constants.Constants
import com.uidemo.navigation.Navigator


 open class BaseActivity : AppCompatActivity() {

     private var actType : Int = 0;
    private var navigator = Navigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
       when (actType){
           Constants().NAVIGATION_TYPE -> {
               navigator.onCreateOptionsMenu(menu)
           }
       }
        return true
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


}