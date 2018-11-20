package sunny.belajarfragmentkotlin.feature.fragment.secondfragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import sunny.belajarfragmentkotlin.R
import sunny.belajarfragmentkotlin.feature.GestureListener
import java.util.*
import kotlin.concurrent.schedule

class SecondFragment : Fragment() {

    lateinit var gestureView:  Button
    lateinit var second: View
    lateinit var fragFirst: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        second = inflater.inflate(R.layout.fragment_second, container, false)
        tx()
        Gesture(second)
        return second
    }

    @SuppressLint("ClickableViewAccessibility")
    fun Gesture(v: View){
        gestureView = v.findViewById(R.id.b_2)

        val gestureListener = GestureListener(gestureView)
        val gd = GestureDetector(activity, gestureListener)

        gestureView.setOnTouchListener { view, motionEvent ->
            gd.onTouchEvent(motionEvent)
            false
        }
    }

    fun tx() {
        Log.d("flow", "tx")
        for (i in 1..10) {
            Timer().schedule(10000) {
                //delaying 10 s
                Log.d("tes", "tx")
            }
        }
    }

}