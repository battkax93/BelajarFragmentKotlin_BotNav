package sunny.belajarfragmentkotlin.feature.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.util.Log
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_bottom_sheet.*
import sunny.belajarfragmentkotlin.R
import android.graphics.drawable.Drawable
import android.graphics.drawable.BitmapDrawable
import android.graphics.Bitmap
import android.graphics.BlurMaskFilter
import android.widget.ImageView
import com.squareup.picasso.Callback
import kotlinx.android.synthetic.main.activity_detail2.*
import org.jetbrains.anko.imageBitmap
import java.lang.Exception


class Detail2Activity : AppCompatActivity() {

    lateinit var displayName2: String
    lateinit var userType2: String
    lateinit var userId2: String
    lateinit var urlAvatar2: String
    lateinit var uiDetail: DetailUI
    lateinit var mBottomSheetBehavior: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)
        getExtra()
        init()
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

        mBottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet2)
        mBottomSheetBehavior.peekHeight = 100
        mBottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
//                    bottomSheetHeading.text = "collapse me"
                    mBottomSheetBehavior.setPeekHeight(100)
                } else {
//                    bottomSheetHeading.text = "expand me"
                }

                // Check Logs to see how bottom sheets behaves
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> Log.d("Bottom Sheet Behaviour", "STATE_COLLAPSED")
                    BottomSheetBehavior.STATE_DRAGGING -> Log.d("Bottom Sheet Behaviour", "STATE_DRAGGING")
                    BottomSheetBehavior.STATE_EXPANDED -> Log.d("Bottom Sheet Behaviour", "STATE_EXPANDED")
                    BottomSheetBehavior.STATE_HIDDEN -> Log.d("Bottom Sheet Behaviour", "STATE_HIDDEN")
                    BottomSheetBehavior.STATE_SETTLING -> Log.d("Bottom Sheet Behaviour", "STATE_SETTLING")
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d("Bottom Sheet Behaviour", "onSlide")
            }
        })

        loadPicOnNewTarget(urlAvatar2)

        Picasso.get().load(urlAvatar2).into(iv_ava2)
        display_name2.text = displayName2
        user_type2.text = userType2
        user_id2.text = userId2

        display_name3.text = displayName2
        user_type3.text = userType2
        user_id3.text = userId2

        /*    mBottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
             override fun onStateChanged(bottomSheet: View, newState: Int) {
                 if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                     mBottomSheetBehavior.setPeekHeight(300)
                 }
             }

             override fun onSlide(bottomSheet: View, slideOffset: Float) {}
         })
    }*/
    }

    fun loadPicOnNewTarget(url: String) {
        val img = ImageView(this)
        Picasso.get()
                .load(url)
                .into(img, object : Callback {
                    override fun onSuccess() {
                        layoutTop.background = img.drawable
                    }

                    override fun onError(e: Exception?) {
                        Log.e("error", "error on loading image")
                    }
                })
    }
}
