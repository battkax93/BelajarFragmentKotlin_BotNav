package sunny.belajarfragmentkotlin.feature.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_bottom_sheet.*
import sunny.belajarfragmentkotlin.R


class DetailActivity : AppCompatActivity() {

    lateinit var displayName2: String
    lateinit var userType2: String
    lateinit var userId2: String
    lateinit var urlAvatar2: String
    lateinit var uiDetail: DetailUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
//        uiDetail = DetailUI()
//        uiDetail.setContentView(this)

        getExtra()
        init()
        appBarListener()
    }

    fun getExtra() {
        displayName2 = intent.extras.getString("displayName")
        userType2 = intent.extras.getString("userType")
        userId2 = intent.extras.getString("userId")
        urlAvatar2 = intent.extras.getString("urlAvatar")
    }


    fun init() {
//        with(uiDetail) {
//            Picasso.get().load(urlAvatar2).into(profilePic)
//            displayName.text = displayName2
//            userId.text = userId2
//            userType.text = userType2
//            cv.setOnClickListener { slideUp(cv) }
//        }

        Picasso.get().load(urlAvatar2).into(iv_ava)

//        tv_title.text = displayName2
        display_name3.text = displayName2
        user_type3.text = userType2
        user_id3.text = userId2

        b_next.setOnClickListener { sendData(displayName2, urlAvatar2, userType2, userId2) }
    }

    fun appBarListener() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        toolbar_layout.title = displayName2
        toolbar_layout.setBackgroundColor(Color.TRANSPARENT)

        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (Math.abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
                //  Collapse
                Log.d("flow", "collapse")
                toolbar.visibility = View.VISIBLE
            } else {
                //Expanded
                Log.d("flow", "expanded")
                toolbar.visibility = View.INVISIBLE
            }
        })
    }

    fun sendData(name: String, urlAvatar: String?, userType: String, userId: String) {
        Log.d("Flow", "adapter.SendData")

        val bundle = Bundle()
        val i = Intent(this, Detail2Activity::class.java)

        bundle.putString("displayName", name)
        bundle.putString("userType", userType)
        bundle.putString("userId", userId)
        bundle.putString("urlAvatar", urlAvatar)

        i.putExtras(bundle)

        ContextCompat.startActivity(this, i, bundle)
    }

}

