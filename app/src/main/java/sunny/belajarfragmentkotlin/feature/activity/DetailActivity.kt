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
import sunny.belajarfragmentkotlin.feature.fragment.AddPhotoBottomDialogFragment


class DetailActivity : AppCompatActivity() {

    lateinit var displayName2: String
    lateinit var userType2: String
    lateinit var userId2: String
    lateinit var urlAvatar2: String
    lateinit var uiDetail: DetailUI
    lateinit var mBottomSheetBehavior: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
//        uiDetail = DetailUI()
//        uiDetail.setContentView(this)

        getExtra()
        init()
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

        mBottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        mBottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetHeading.text = "collapse me"
                    mBottomSheetBehavior.setPeekHeight(100)
                } else {
                    bottomSheetHeading.text = "expand me"
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

        Picasso.get().load(urlAvatar2).into(iv_ava)
        display_name.text = displayName2
        user_type.text = userType2
        user_id.text = userId2

        Picasso.get().load(urlAvatar2).into(iv_ava3)
        display_name3.text = displayName2
        user_type3.text = userType2
        user_id3.text = userId2

       /* mBottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setPeekHeight(300)
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })*/
    }
}

