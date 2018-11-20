package sunny.belajarfragmentkotlin.feature.fragment.thirdfragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.util.Log
import android.view.*
import android.widget.*
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.support.v4.UI
import sunny.belajarfragmentkotlin.R
import sunny.belajarfragmentkotlin.entity.model.Github
import sunny.belajarfragmentkotlin.feature.GestureListener
import sunny.kotlinmoviechart.network.api.GithubApi

class ThirdFragment : Fragment(), ContractThirdFragment.mainView {

    lateinit var etUsername: EditText
    lateinit var tabLayout: TabLayout
    lateinit var bId: Button
    lateinit var iv: ImageView
    lateinit var un: TextView
    lateinit var cp: TextView
    lateinit var cv: CardView

    lateinit var api: GithubApi
    lateinit var present: ContractThirdFragment.mainPresenter

    var value: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return UI {
            verticalLayout {
                gravity = Gravity.CENTER_VERTICAL
                lparams(matchParent, matchParent)
                padding = dip(16)
                setBackgroundColor(resources.getColor(R.color.gray))

                etUsername = editText {
                    hint = "input your username"
                }.lparams(matchParent, wrapContent)
                bId = button().lparams(matchParent, wrapContent)

                cv = cardView {
                    lparams(matchParent, wrapContent)
                    setBackgroundColor(resources.getColor(R.color.white))
                    visibility = View.GONE

                    verticalLayout {
                        lparams(matchParent, wrapContent)
                        padding = dip(10)

                        iv = imageView().lparams(matchParent, wrapContent)
                        un = textView().lparams(wrapContent, wrapContent)
                        cp = textView().lparams(wrapContent, wrapContent)
                    }
                }
            }
        }.view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        action()
        Gesture(cv)
    }

    fun Gesture(v: View) {


        v.setOnTouchListener { view, motionEvent ->
            var gestureListener: GestureListener
            if(!value) {
                gestureListener = GestureListener(v, value)
            } else {
                gestureListener = GestureListener(v,!value)
            }
            var gd = GestureDetector(activity, gestureListener)
            gd.onTouchEvent(motionEvent)
            false
        }
    }

    override fun init() {
        present = PresentThirdFragment(this)
        api = GithubApi()
    }

    override fun action() {
        Log.d("FLOW", "action")
        bId.setOnClickListener {
            val value = etUsername.text.toString()
            Log.d("cek", "" + value)
            Toast.makeText(requireContext(), "clicked", Toast.LENGTH_SHORT).show()
            present.getData(api, requireContext(), value)
        }
    }

    fun animateView(v: View) {
        YoYo.with(Techniques.SlideInUp)
                .duration(1500)
                .playOn(v)
    }

    override fun updateUI(user: Github) {
        etUsername.visibility = View.GONE
        bId.visibility = View.GONE

        cv.visibility = View.VISIBLE
        animateView(cv)
        Picasso.get().load(user.avatarUrl).into(iv)
        un.text = user.name
        cp.text = user.company
    }

}
