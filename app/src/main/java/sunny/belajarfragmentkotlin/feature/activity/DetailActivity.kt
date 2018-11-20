package sunny.belajarfragmentkotlin.feature.activity

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
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

    lateinit var bottomSheet: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
//        uiDetail = DetailUI()
//        uiDetail.setContentView(this)

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
//        with(uiDetail) {
//            Picasso.get().load(urlAvatar2).into(profilePic)
//            displayName.text = displayName2
//            userId.text = userId2
//            userType.text = userType2
//            cv.setOnClickListener { slideUp(cv) }
//        }

        bottomSheet.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetHeading.text = "collapse me"
                } else {
                    bottomSheetHeading.text = "expand me"
                }

                // Check Logs to see how bottom sheets behaves
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> Log.e("Bottom Sheet Behaviour", "STATE_COLLAPSED")
                    BottomSheetBehavior.STATE_DRAGGING -> Log.e("Bottom Sheet Behaviour", "STATE_DRAGGING")
                    BottomSheetBehavior.STATE_EXPANDED -> Log.e("Bottom Sheet Behaviour", "STATE_EXPANDED")
                    BottomSheetBehavior.STATE_HIDDEN -> Log.e("Bottom Sheet Behaviour", "STATE_HIDDEN")
                    BottomSheetBehavior.STATE_SETTLING -> Log.e("Bottom Sheet Behaviour", "STATE_SETTLING")
                }
            }


            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })

            Picasso.get().load(urlAvatar2).into(iv_ava)
            display_name.text = displayName2
            user_type.text = userType2
            user_id.text = userId2
        }


//                fun slideUp (view: View) {
//            val animate = TranslateAnimation(
//                    0f, // fromXDelta
//                    0f, // toXDelta
//                    (view.height * 2).toFloat(), // fromYDelta
//                    0f)                // toYDelta
//            animate.duration = 1000
//            animate.fillAfter = true
//            view.startAnimation(animate)
//        }

//        fun slideDown(view: View) {
//            val animate = TranslateAnimation(
//                    0f, // fromXDelta
//                    0f, // toXDelta
//                    0f, // fromYDelta
//                    (view.height * 2).toFloat()) // toYDelta
//            animate.duration = 1000
//            animate.fillAfter = true
//            view.startAnimation(animate)
//        }

//        fun animateButton(v: View) {
//            YoYo.with(Techniques.RubberBand)
//                    .duration(2000)
//                    .playOn(v)
//        }


    }

