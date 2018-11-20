package sunny.belajarfragmentkotlin.feature.fragment.thirdfragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI
import sunny.belajarfragmentkotlin.entity.model.Github
import sunny.kotlinmoviechart.network.api.GithubApi

class ThirdFragment : Fragment(), ContractThirdFragment.mainView {

    lateinit var etUsername: EditText
    lateinit var tabLayout: TabLayout
    lateinit var bId: Button
    lateinit var iv: ImageView
    lateinit var un: TextView
    lateinit var cp: TextView

    lateinit var api: GithubApi
    lateinit var present: ContractThirdFragment.mainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return UI {
            verticalLayout {
                gravity = Gravity.CENTER_VERTICAL
                lparams(matchParent, wrapContent)
                padding = dip(16)


                etUsername = editText {
                    hint = "input your username"
                }.lparams(matchParent, wrapContent)

                bId = button().lparams(matchParent, wrapContent)

                verticalLayout {
                    lparams(matchParent, wrapContent)
                    padding = dip(10)

                    iv = imageView().lparams(matchParent, wrapContent)
                    un = textView().lparams(wrapContent, wrapContent)
                    cp = textView().lparams(wrapContent, wrapContent)
                }
            }
        }.view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        action()
    }



    override fun init() {
        present = PresentThirdFragment(this)
        api = GithubApi()
    }

    override fun action() {
        Log.d("FLOW","action")
        bId.setOnClickListener {
            val value = etUsername.text.toString()
            Log.d("cek", ""+value)
            Toast.makeText(requireContext(),"clicked",Toast.LENGTH_SHORT).show()
            present.getData(api, requireContext(), value)
        }
    }

    override fun updateUI(user: Github) {
        Picasso.get().load(user.avatarUrl).into(iv)
        un.text = user.name
        cp.text = user.company
    }

}
