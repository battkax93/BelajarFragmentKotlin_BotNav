package sunny.belajarfragmentkotlin.feature.activity

import android.gesture.GestureStroke
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.transition.Visibility
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_main.*
import sunny.belajarfragmentkotlin.R
import sunny.belajarfragmentkotlin.feature.fragment.firstfragment.FirstFragment
import sunny.belajarfragmentkotlin.feature.fragment.secondfragment.SecondFragment

class MainActivity : FragmentActivity() {

    lateinit var scnd: SecondFragment
    lateinit var frst: FirstFragment
    lateinit var nav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment()
        scnd = SecondFragment()
        frst = FirstFragment()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
//                message.setText(R.string.title_home)
                showToast()
                replaceToast(frst)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
//                message.setText(R.string.title_dashboard)
                showToast()
                replaceToast(scnd)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
//                message.setText(R.string.title_notifications)
                showToast()

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    fun showToast() {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
    }

    fun loadFragment() {
        if (supportFragmentManager.findFragmentById(R.id.container2) == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.container2, FirstFragment())
                    .commit()
        }
    }

    fun replaceToast(fragment: Fragment) {
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container2, fragment)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
    }

    fun playAnimation(v: View,action: String) {
        if (action == "down") {
            Log.d("flow", "slide up")
            YoYo.with(Techniques.SlideInUp)
                    .duration(500)
                    .playOn(v)
            v.visibility = View.VISIBLE
        } else {
            Log.d("flow", "slide down")
            YoYo.with(Techniques.SlideInDown)
                    .duration(500)
                    .playOn(v)
            v.visibility = View.GONE
        }
    }
}
