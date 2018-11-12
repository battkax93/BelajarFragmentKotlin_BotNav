package sunny.belajarfragmentkotlin.feature.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.TextView
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.setContentView
import sunny.belajarfragmentkotlin.R

class DetailActivity : AppCompatActivity() {

    lateinit var displayName2: String
    lateinit var userType2: String
    lateinit var userId2: String
    lateinit var urlAvatar2: String
    lateinit var uiDetail: DetailUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)
        uiDetail = DetailUI()
        uiDetail.setContentView(this)


        getExtra()
        init()
//        cv.setOnClickListener { slideUp(cv) }
    }

    fun getExtra() {
        displayName2 = intent.extras.getString("displayName")
        userType2 = intent.extras.getString("userType")
        userId2 = intent.extras.getString("userId")
        urlAvatar2 = intent.extras.getString("urlAvatar")
    }

    fun init() {
        with(uiDetail) {
            Picasso.get().load(urlAvatar2).into(profilePic)
            displayName.text = displayName2
            userId.text = userId2
            userType.text = userType2
            cv.setOnClickListener { slideUp(cv) }
        }
//        Picasso.get().load(urlAvatar).into(iv_ava)
//        display_name.text = displayName
//        user_type.text = userType
//        user_id.text = userId
    }

    fun slideUp(view: View) {
        val animate = TranslateAnimation(
                0f, // fromXDelta
                0f, // toXDelta
                (view.height * 2).toFloat(), // fromYDelta
                0f)                // toYDelta
        animate.duration = 1000
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    fun slideDown(view: View) {
        val animate = TranslateAnimation(
                0f, // fromXDelta
                0f, // toXDelta
                0f, // fromYDelta
                (view.height * 2).toFloat()) // toYDelta
        animate.duration = 1000
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    fun animateButton(v: View) {
        YoYo.with(Techniques.RubberBand)
                .duration(2000)
                .playOn(v)
    }


}
