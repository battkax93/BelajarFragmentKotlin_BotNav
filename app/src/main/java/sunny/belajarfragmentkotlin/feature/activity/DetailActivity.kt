package sunny.belajarfragmentkotlin.feature.activity

import android.R.attr.action
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_bottom_sheet.*
import sunny.belajarfragmentkotlin.R
import sunny.belajarfragmentkotlin.feature.fragment.AddPhotoBottomDialogFragment
import android.support.design.widget.AppBarLayout
import android.R.attr.data
import android.app.PendingIntent.getActivity
import android.support.v4.view.ViewCompat
import android.support.v7.app.ActionBar
import android.util.TypedValue
import android.view.ActionMode
import org.jetbrains.anko.dimenAttr
import android.opengl.ETC1.getHeight
import android.view.ViewTreeObserver
import android.widget.Toast
import sunny.belajarfragmentkotlin.R.id.scroll
import android.support.v4.widget.NestedScrollView




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
//        loadBottomDialog()
//        cv.setOnClickListener { slideUp(cv) }
    }

    fun getExtra() {
        displayName2 = intent.extras.getString("displayName")
        userType2 = intent.extras.getString("userType")
        userId2 = intent.extras.getString("userId")
        urlAvatar2 = intent.extras.getString("urlAvatar")
    }

    /* fun loadBottomDialog(){
         val addPhotoBottomDialogFragment = AddPhotoBottomDialogFragment.newInstance()
         addPhotoBottomDialogFragment.show(supportFragmentManager,
                 "add_photo_dialog_fragment")
     }*/

    fun init() {
//        with(uiDetail) {
//            Picasso.get().load(urlAvatar2).into(profilePic)
//            displayName.text = displayName2
//            userId.text = userId2
//            userType.text = userType2
//            cv.setOnClickListener { slideUp(cv) }
//        }

        Picasso.get().load(urlAvatar2).into(iv_ava)

        display_name3.text = displayName2
        user_type3.text = userType2
        user_id3.text = userId2

        b_next.setOnClickListener { sendData(displayName2, urlAvatar2, userType2, userId2) }
    }

    fun appBarListener() {

        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (Math.abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
                //  Collapse
                toolbar.visibility = View.VISIBLE
                setSupportActionBar(toolbar)
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)


            } else {
                //Expanded
                toolbar.visibility = View.GONE

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

