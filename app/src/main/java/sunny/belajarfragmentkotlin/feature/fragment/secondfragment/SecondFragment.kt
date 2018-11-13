package sunny.belajarfragmentkotlin.feature.fragment.secondfragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.*
import sunny.belajarfragmentkotlin.R
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.thread
import kotlin.coroutines.coroutineContext

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val second = inflater.inflate(R.layout.fragment_second, container, false)
        tx()
        return second
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